package org.waa.sme.scenebuilder;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
        List<String> bob = httpHelper.loadListeAmis(id);
        if (bob != null) {
            vueListeAmi = new ListView<>();
            vueListeAmi.setItems(FXCollections.observableList(bob));

            vueListeAmi.setItems(FXCollections.observableArrayList(bob));


            System.out.println(bob.get(0));
            System.out.println(vueListeAmi);
            //setFriendList(data);
        }

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

    //Text & search field zone
    @FXML
    private TextField searchFriend;
    @FXML
    private TextField searchMessage;

    //Friend List view zone
    @FXML
    private ListView<String> vueListeAmi;
    @FXML
    private ListView<String> vueMessages;

    String[] amis = {"Bob le testeur fou", "Babar", "Antoine Daniel (le YouTuber)", "Patrick Sébastien", "Jotaro Kujo", "le mec de Halo"};
    String[] addAll;
    String selectionAmi;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            vueListeAmi.getItems().addAll(httpHelper.loadListeAmis(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        vueListeAmi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                selectionAmi = vueListeAmi.getSelectionModel().getSelectedItem();

                friendLabel.setText(selectionAmi);
            }
        });
    }

    public void userLogOut() throws IOException {
        DiscordoApp m = new DiscordoApp();
        m.changeScene("Login.fxml");
    }

    //ObservableList<String> items = FXCollections.observableArrayList (
    //        "Single", "Double", "Suite", "Family App");
    //list.setItems(items);
}