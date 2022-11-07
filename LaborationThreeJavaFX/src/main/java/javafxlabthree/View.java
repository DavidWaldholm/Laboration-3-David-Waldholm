package javafxlabthree;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends javafx.application.Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("JavaFX Canvas by David Waldholm");
        FXMLLoader fxmlLoader = new FXMLLoader(View.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Paint");
        stage.setScene(scene);
        stage.show();
    }
}