package org.waa.sme.scenebuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    public LoginController() {

    }
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongPassword;
    @FXML
    private Button loginButton;


    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        DiscordoApp m = new DiscordoApp();
        if(username.getText().toString().equals("alexis") && password.getText().toString().equals("Azerty$123")) {
            wrongPassword.setText("Connexion réussie !");

            m.changeScene("Home.fxml");

        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongPassword.setText("Veuillez remplir les champs");
        }

        else {
            wrongPassword.setText("Identifiant ou mot de passe incorrect");
        }
    }
}
