package org.waa.sme.scenebuilder;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import org.waa.sme.utils.IdSingleton;
import org.waa.sme.utils.Httphelper;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.fxml.FXML;
import java.util.List;
import java.net.URL;

public class DiscordoController implements Initializable {

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

    //Friend List view zone
    @FXML
    private ListView<String> vueListeAmi;

    String[] amis = {"Bob le testeur fou", "Babar", "Antoine Daniel (le YouTuber)", "Patrick Sébastien", "Jotaro Kujo", "le mec de Halo"};

    String selectionAmi;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vueListeAmi.getItems().addAll(amis);
        vueListeAmi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                selectionAmi = vueListeAmi.getSelectionModel().getSelectedItem();

                friendLabel.setText(selectionAmi);
            }
        });
    }

    //ObservableList<String> items = FXCollections.observableArrayList (
    //        "Single", "Double", "Suite", "Family App");
    //list.setItems(items);
}