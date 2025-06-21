package jour05;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class Job02 extends Application {
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("New Window");

    BorderPane borderPane = new BorderPane();
    Button quitButton = new Button("Quitter");
    quitButton.setOnAction(e -> {
      primaryStage.close();
    });

    VBox vbox = new VBox(quitButton);
    vbox.setAlignment(Pos.CENTER);
    vbox.setPadding(new Insets(0, 0, 30, 0)); // 30px from the botom

    borderPane.setBottom(vbox);

    Scene scene = new Scene(borderPane, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}