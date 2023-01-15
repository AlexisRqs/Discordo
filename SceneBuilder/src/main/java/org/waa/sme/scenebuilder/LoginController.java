package org.waa.sme.scenebuilder;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.waa.sme.utils.IdSingleton;
import org.waa.sme.utils.Httphelper;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.*;

public class LoginController {
    //@Autowired
    private Httphelper httpHelper;

    public LoginController() {

    }

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongPassword;
    @FXML
    private Button registerButton;

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    public void userRegister() throws IOException {
        DiscordoApp m = new DiscordoApp();
        m.changeScene("Register.fxml");
    }

    /**
     * Méthode qui permet de vérifier si les champs sont remplis,
     * Puis verifie avec checkPassword si le mail/mdp est correct
     */
    private void checkLogin() {
        DiscordoApp m = new DiscordoApp();

        String mail = username.getText();
        String pwd = password.getText();

        if (!mail.equals("") && !pwd.equals("")) {
            try {
                Long id = httpHelper.checkPassword(mail, pwd);
                if (id != null) {
                    IdSingleton.getInstance().setId(id);
                    System.out.println("NOUS VOILA ICI VIVANT VAILLANT :" + id);
                    m.changeScene("Home.fxml");
                } else {
                    wrongPassword.setText("Mauvais mail/mdp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (mail.equals("") && pwd.equals("")) {
            wrongPassword.setText("Veuillez remplir les champs");
        } else {
            if (mail.equals("")) {
                wrongPassword.setText("Veuillez saisir une adresse e-mail");
            }
            if (pwd.equals("")) {
                wrongPassword.setText("Veuillez saisir un mot de passe");
            }
        }
    }

}
