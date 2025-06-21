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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.stage.FileChooser;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Job07 extends Application {
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

    // GridPane au centre pour alignement vertical
    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(20);
    gridPane.setVgap(20);
    gridPane.setPadding(new Insets(30, 0, 30, 0));

    // Première ligne : IP/domain
    Label nameLabel1 = new Label("Target IP or Domain Name:");
    TextField nameField1 = new TextField();
    Button sendButton1 = new Button("Send");
    sendButton1.setOnAction(e -> {
      System.out.println("IP/Domain: " + nameField1.getText());
    });
    gridPane.add(nameLabel1, 0, 0);
    gridPane.add(nameField1, 1, 0);
    gridPane.add(sendButton1, 2, 0);

    // Deuxième ligne : Port range
    Label nameLabel2 = new Label("Target Port range :");
    TextField nameField2 = new TextField();
    Button sendButton2 = new Button("Send");
    sendButton2.setOnAction(e -> {
      System.out.println("Port range: " + nameField2.getText());
    });
    gridPane.add(nameLabel2, 0, 1);
    gridPane.add(nameField2, 1, 1);
    gridPane.add(sendButton2, 2, 1);

    // Troisième ligne : ComboBox Ports
    Label portsLabel = new Label("Ports:");
    ComboBox<String> portsCombo = new ComboBox<>();
    portsCombo.getItems().addAll("TCP", "UDP", "Both");
    portsCombo.getSelectionModel().selectFirst();
    gridPane.add(portsLabel, 0, 2);
    gridPane.add(portsCombo, 1, 2);

    // Quatrième ligne : ComboBox Scan Type
    Label scanTypeLabel = new Label("Scan Type:");
    ComboBox<String> scanTypeCombo = new ComboBox<>();
    scanTypeCombo.getItems().addAll("Fast Scan", "Full Scan", "Custom scan");
    scanTypeCombo.getSelectionModel().selectFirst();
    gridPane.add(scanTypeLabel, 0, 3);
    gridPane.add(scanTypeCombo, 1, 3);

    // Cinquième ligne : bouton OK
    Button okButton = new Button("OK");
    okButton.setOnAction(e -> {
      String ports = portsCombo.getValue();
      String scanType = scanTypeCombo.getValue();
      System.out.println("Ports: " + ports + ", Scan Type: " + scanType);
    });
    gridPane.add(okButton, 1, 4);

    // TableView pour les résultats de scan
    TableView<ScanResult> table = new TableView<>();
    table.setItems(getMockData());
    table.setPrefHeight(200);
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    TableColumn<ScanResult, String> ipCol = new TableColumn<>("IP Address");
    ipCol.setCellValueFactory(new PropertyValueFactory<>("ipAddress"));
    TableColumn<ScanResult, String> portCol = new TableColumn<>("Port");
    portCol.setCellValueFactory(new PropertyValueFactory<>("port"));
    TableColumn<ScanResult, String> protoCol = new TableColumn<>("Protocol");
    protoCol.setCellValueFactory(new PropertyValueFactory<>("protocol"));
    TableColumn<ScanResult, String> statusCol = new TableColumn<>("Status");
    statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    TableColumn<ScanResult, String> serviceCol = new TableColumn<>("Service");
    serviceCol.setCellValueFactory(new PropertyValueFactory<>("service"));
    TableColumn<ScanResult, String> bannerCol = new TableColumn<>("Banner Info");
    bannerCol.setCellValueFactory(new PropertyValueFactory<>("bannerInfo"));
    TableColumn<ScanResult, Long> scanTimeCol = new TableColumn<>("Scan Time (ms)");
    scanTimeCol.setCellValueFactory(new PropertyValueFactory<>("scanTime"));
    TableColumn<ScanResult, String> scanTimestampCol = new TableColumn<>("Scan Timestamp");
    scanTimestampCol.setCellValueFactory(new PropertyValueFactory<>("scanTimestamp"));

    table.getColumns().addAll(ipCol, portCol, protoCol, statusCol, serviceCol, bannerCol, scanTimeCol,
        scanTimestampCol);

    VBox centerBox = new VBox(20, gridPane, table);
    centerBox.setAlignment(Pos.CENTER);
    centerBox.setPadding(new Insets(20, 0, 0, 0));
    borderPane.setCenter(centerBox);

    // Bouton Exporter
    Button exportButton = new Button("Exporter");
    exportButton.setOnAction(e -> {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Save CSV");
      fileChooser.setInitialFileName("scan_results.csv");
      fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
      java.io.File file = fileChooser.showSaveDialog(primaryStage);
      if (file != null) {
        exportToCSV(table.getItems(), file.getAbsolutePath());
      }
    });
    exportButton.getStyleClass().add("button");
    VBox exportBox = new VBox(exportButton);
    exportBox.setAlignment(Pos.CENTER);
    exportBox.setPadding(new Insets(10, 0, 0, 0));
    centerBox.getChildren().add(exportBox);

    // Bouton Quit en bas, centré et remonté
    Button quitButton = new Button("Quit");
    quitButton.setOnAction(e -> primaryStage.close());
    VBox vbox = new VBox(quitButton);
    vbox.setAlignment(Pos.CENTER);
    vbox.setPadding(new Insets(0, 0, 30, 0));
    borderPane.setBottom(vbox);

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