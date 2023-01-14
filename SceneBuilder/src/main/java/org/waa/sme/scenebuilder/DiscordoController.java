package org.waa.sme.scenebuilder;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import org.waa.sme.utils.IdSingleton;
import org.waa.sme.utils.Httphelper;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import javafx.fxml.FXML;
import java.util.List;

public class DiscordoController {

    private Httphelper httpHelper;

    private Long id = IdSingleton.getInstance().getId();

    public DiscordoController() throws IOException {
        List bob = httpHelper.loadListeAmis(id);
        if (bob != null) {
            ListView<String> listView = new ListView<>();
            listView.setItems(FXCollections.observableList(bob));

            ObservableList<String> data = FXCollections.observableArrayList(bob);

            System.out.println(bob.get(0));
            System.out.println(listView);
            setFriendList(data);
        }

    }



    public void setFriendList(ObservableList listView) {
        //friendList.getItems().addAll(listView);
        //friendList.setItems(listView);
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
    private ListView friendList;


    @FXML
    protected void onemojiButtonClick() {
        welcomeText.setText("Bienvenue sur Discordo !");
    }




    ListView<String> list = new ListView<String>();
    //ObservableList<String> items = FXCollections.observableArrayList (
    //        "Single", "Double", "Suite", "Family App");
    //list.setItems(items);
}