package org.waa.sme.scenebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DiscordoController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Bienvenue sur Discordo !");
    }
}