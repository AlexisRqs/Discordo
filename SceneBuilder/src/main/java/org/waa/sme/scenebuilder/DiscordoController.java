package org.waa.sme.scenebuilder;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DiscordoController {

    public DiscordoController() {

    }

    //Buttons zone
    @FXML
    private Button addFriendButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button emojiButton;
    @FXML
    private Button commandButton;

    //Labels field zone
    @FXML
    private Label friendLabel;
    @FXML
    private Label loggedAs;
    @FXML
    private Label appVersion;
    @FXML
    private Label welcomeText;

    //Search field zone
    @FXML
    private TextField searchFriend;
    @FXML
    private TextField searchMessage;


    @FXML
    protected void onemojiButtonClick() {
        welcomeText.setText("Bienvenue sur Discordo !");
    }

    ListView<String> list = new ListView<String>();
    //ObservableList<String> items = FXCollections.observableArrayList (
    //        "Single", "Double", "Suite", "Family App");
    //list.setItems(items);
}