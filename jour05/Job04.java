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
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Job04 extends Application {
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

    Label nameLabel1 = new Label("Target IP or Domain Name:");
    TextField nameField1 = new TextField();
    Button sendButton1 = new Button("Scan");
    gridPane.add(nameLabel1, 0, 0);
    gridPane.add(nameField1, 1, 0);
    gridPane.add(sendButton1, 2, 0);

    Label nameLabel2 = new Label("Target Port range :");
    TextField nameField2 = new TextField();
    Button sendButton2 = new Button("Scan");
    gridPane.add(nameLabel2, 0, 1);
    gridPane.add(nameField2, 1, 1);
    gridPane.add(sendButton2, 2, 1);

    borderPane.setCenter(gridPane);

    // Bouton Quitter en bas, centré et remonté
    Button quitButton = new Button("Quit");
    quitButton.setOnAction(e -> primaryStage.close());
    VBox vbox = new VBox(quitButton);
    vbox.setAlignment(Pos.CENTER);
    vbox.setPadding(new Insets(0, 0, 30, 0));
    borderPane.setBottom(vbox);

    Scene scene = new Scene(borderPane, 800, 600);
    scene.getStylesheets().add(getClass().getResource("cyberpunk.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}