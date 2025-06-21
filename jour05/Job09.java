package jour05;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.stage.FileChooser;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Job09 extends Application {
  public static class ScanResult {
    private final SimpleStringProperty ipAddress;
    private final SimpleStringProperty port;
    private final SimpleStringProperty protocol;
    private final SimpleStringProperty status;
    private final SimpleStringProperty service;
    private final SimpleStringProperty bannerInfo;
    private final SimpleLongProperty scanTime;
    private final SimpleStringProperty scanTimestamp;

    public ScanResult(String ip, String port, String protocol, String status, String service, String banner,
        long scanTime, String scanTimestamp) {
      this.ipAddress = new SimpleStringProperty(ip);
      this.port = new SimpleStringProperty(port);
      this.protocol = new SimpleStringProperty(protocol);
      this.status = new SimpleStringProperty(status);
      this.service = new SimpleStringProperty(service);
      this.bannerInfo = new SimpleStringProperty(banner);
      this.scanTime = new SimpleLongProperty(scanTime);
      this.scanTimestamp = new SimpleStringProperty(scanTimestamp);
    }

    public String getIpAddress() {
      return ipAddress.get();
    }

    public String getPort() {
      return port.get();
    }

    public String getProtocol() {
      return protocol.get();
    }

    public String getStatus() {
      return status.get();
    }

    public String getService() {
      return service.get();
    }

    public String getBannerInfo() {
      return bannerInfo.get();
    }

    public long getScanTime() {
      return scanTime.get();
    }

    public String getScanTimestamp() {
      return scanTimestamp.get();
    }
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Port Scanner");

    BorderPane borderPane = new BorderPane();
    TabPane tabPane = new TabPane();
    borderPane.setCenter(tabPane);

    // Main tab: only the form, ComboBoxes, Send/OK, Scan Results, Quit
    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(20);
    gridPane.setVgap(20);
    gridPane.setPadding(new Insets(30, 0, 30, 0));

    // First row: IP/domain
    Label nameLabel1 = new Label("Target IP or Domain Name:");
    TextField nameField1 = new TextField();
    Button sendButton1 = new Button("Send");
    sendButton1.setOnAction(e -> {
      System.out.println("IP/Domain: " + nameField1.getText());
    });
    gridPane.add(nameLabel1, 0, 0);
    gridPane.add(nameField1, 1, 0);
    gridPane.add(sendButton1, 2, 0);

    // Second row: Port range
    Label nameLabel2 = new Label("Target Port range :");
    TextField nameField2 = new TextField();
    Button sendButton2 = new Button("Send");
    sendButton2.setOnAction(e -> {
      System.out.println("Port range: " + nameField2.getText());
    });
    gridPane.add(nameLabel2, 0, 1);
    gridPane.add(nameField2, 1, 1);
    gridPane.add(sendButton2, 2, 1);

    // Third row: ComboBox Ports
    Label portsLabel = new Label("Ports:");
    ComboBox<String> portsCombo = new ComboBox<>();
    portsCombo.getItems().addAll("TCP", "UDP", "Both");
    portsCombo.getSelectionModel().selectFirst();
    gridPane.add(portsLabel, 0, 2);
    gridPane.add(portsCombo, 1, 2);

    // Fourth row: ComboBox Scan Type
    Label scanTypeLabel = new Label("Scan Type:");
    ComboBox<String> scanTypeCombo = new ComboBox<>();
    scanTypeCombo.getItems().addAll("Fast Scan", "Full Scan", "Custom scan");
    scanTypeCombo.getSelectionModel().selectFirst();
    gridPane.add(scanTypeLabel, 0, 3);
    gridPane.add(scanTypeCombo, 1, 3);

    // Fifth row: OK button
    Button okButton = new Button("OK");
    okButton.setOnAction(e -> {
      String ports = portsCombo.getValue();
      String scanType = scanTypeCombo.getValue();
      System.out.println("Ports: " + ports + ", Scan Type: " + scanType);
    });
    gridPane.add(okButton, 1, 4);

    // Scan Results button
    Button scanResultsButton = new Button("Scan Results");
    VBox scanButtonBox = new VBox(scanResultsButton);
    scanButtonBox.setAlignment(Pos.CENTER);
    scanButtonBox.setPadding(new Insets(10, 0, 0, 0));

    // Quit button with confirmation dialog
    Button quitButton = new Button("Quit");
    quitButton.setOnAction(e -> {
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Confirmation");
      alert.setHeaderText("Quit Application");
      alert.setContentText("Are you sure you want to quit?");
      Optional<ButtonType> result = alert.showAndWait();
      if (result.isPresent() && result.get() == ButtonType.OK) {
        primaryStage.close();
      }
    });
    VBox quitBox = new VBox(quitButton);
    quitBox.setAlignment(Pos.CENTER);
    quitBox.setPadding(new Insets(10, 0, 0, 0));

    VBox mainBox = new VBox(20, gridPane, scanButtonBox, quitBox);
    mainBox.setAlignment(Pos.CENTER);
    mainBox.setPadding(new Insets(20, 0, 0, 0));

    Tab mainTab = new Tab("Main", mainBox);
    mainTab.setClosable(false);
    tabPane.getTabs().add(mainTab);

    // Add new tab with table and export button on Scan Results click
    scanResultsButton.setOnAction(e -> {
      Tab resultsTab = new Tab("Result" + (tabPane.getTabs().size()));
      VBox tabContent = new VBox(20);
      tabContent.setAlignment(Pos.CENTER);
      tabContent.setPadding(new Insets(20, 0, 0, 0));

      TableView<ScanResult> tabTable = new TableView<>();
      tabTable.setItems(getMockData());
      tabTable.setPrefHeight(200);
      tabTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

      TableColumn<ScanResult, String> tabIpCol = new TableColumn<>("IP Address");
      tabIpCol.setCellValueFactory(new PropertyValueFactory<>("ipAddress"));
      TableColumn<ScanResult, String> tabPortCol = new TableColumn<>("Port");
      tabPortCol.setCellValueFactory(new PropertyValueFactory<>("port"));
      TableColumn<ScanResult, String> tabProtoCol = new TableColumn<>("Protocol");
      tabProtoCol.setCellValueFactory(new PropertyValueFactory<>("protocol"));
      TableColumn<ScanResult, String> tabStatusCol = new TableColumn<>("Status");
      tabStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
      TableColumn<ScanResult, String> tabServiceCol = new TableColumn<>("Service");
      tabServiceCol.setCellValueFactory(new PropertyValueFactory<>("service"));
      TableColumn<ScanResult, String> tabBannerCol = new TableColumn<>("Banner Info");
      tabBannerCol.setCellValueFactory(new PropertyValueFactory<>("bannerInfo"));
      TableColumn<ScanResult, Long> tabScanTimeCol = new TableColumn<>("Scan Time (ms)");
      tabScanTimeCol.setCellValueFactory(new PropertyValueFactory<>("scanTime"));
      TableColumn<ScanResult, String> tabScanTimestampCol = new TableColumn<>("Scan Timestamp");
      tabScanTimestampCol.setCellValueFactory(new PropertyValueFactory<>("scanTimestamp"));

      tabTable.getColumns().addAll(tabIpCol, tabPortCol, tabProtoCol, tabStatusCol, tabServiceCol, tabBannerCol,
          tabScanTimeCol, tabScanTimestampCol);

      Button tabExportButton = new Button("Exporter");
      tabExportButton.setOnAction(ev -> {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save CSV");
        fileChooser.setInitialFileName("scan_results.csv");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        java.io.File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
          exportToCSV(tabTable.getItems(), file.getAbsolutePath());
        }
      });
      tabExportButton.getStyleClass().add("button");
      VBox tabExportBox = new VBox(tabExportButton);
      tabExportBox.setAlignment(Pos.CENTER);
      tabExportBox.setPadding(new Insets(10, 0, 0, 0));

      tabContent.getChildren().addAll(tabTable, tabExportBox);
      resultsTab.setContent(tabContent);
      tabPane.getTabs().add(resultsTab);
      tabPane.getSelectionModel().select(resultsTab);
    });

    Scene scene = new Scene(borderPane, 1000, 700);
    scene.getStylesheets().add(getClass().getResource("cyberpunk.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private ObservableList<ScanResult> getMockData() {
    ObservableList<ScanResult> data = FXCollections.observableArrayList();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    data.add(new ScanResult("192.168.1.1", "80", "TCP", "Open", "HTTP", "Apache/2.4.1", 12,
        LocalDateTime.now().format(dtf)));
    data.add(new ScanResult("192.168.1.1", "22", "TCP", "Closed", "SSH", "", 8, LocalDateTime.now().format(dtf)));
    data.add(new ScanResult("192.168.1.2", "443", "TCP", "Open", "HTTPS", "nginx/1.18.0", 15,
        LocalDateTime.now().format(dtf)));
    data.add(
        new ScanResult("192.168.1.3", "53", "UDP", "Open", "DNS", "BIND 9.11.3", 20, LocalDateTime.now().format(dtf)));
    return data;
  }

  private void exportToCSV(ObservableList<ScanResult> data, String filePath) {
    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write("IP Address,Port,Protocol,Status,Service,Banner Info,Scan Time (ms),Scan Timestamp\n");
      for (ScanResult r : data) {
        writer.write(String.format("%s,%s,%s,%s,%s,%s,%d,%s\n",
            r.getIpAddress(), r.getPort(), r.getProtocol(), r.getStatus(),
            r.getService(), r.getBannerInfo(), r.getScanTime(), r.getScanTimestamp()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}