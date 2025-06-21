package jour05;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Job03 extends Application {
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Server Logs");

    BorderPane borderPane = new BorderPane();

    // FlowPane au centre
    FlowPane flowPane = new FlowPane();
    flowPane.setAlignment(Pos.CENTER);
    flowPane.setHgap(10);
    flowPane.setVgap(10);
    flowPane.setPadding(new Insets(30, 0, 30, 0));

    Label nameLabel = new Label("Nom :");
    TextField nameField = new TextField();
    Button sendButton = new Button("Envoyer");
    flowPane.getChildren().addAll(nameLabel, nameField, sendButton);
    borderPane.setCenter(flowPane);

    // Bouton Quitter en bas, centré et remonté
    Button quitButton = new Button("Quitter");
    quitButton.setOnAction(e -> primaryStage.close());
    VBox vbox = new VBox(quitButton);
    vbox.setAlignment(Pos.CENTER);
    vbox.setPadding(new Insets(0, 0, 30, 0));
    borderPane.setBottom(vbox);

    Scene scene = new Scene(borderPane, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}