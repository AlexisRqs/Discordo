package org.waa.sme.scenebuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DiscordoApp extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws Exception {
        stg = stage;
        stage.setResizable(false);
        //FXMLLoader fxmlLoader = new FXMLLoader(DiscordoApp.class.getResource("Scenebuilder1.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("Discordo");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}