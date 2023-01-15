package org.waa.sme.scenebuilder;

import javafx.scene.control.PasswordField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.waa.sme.utils.IdSingleton;
import org.waa.sme.utils.Httphelper;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.*;


public class RegisterController {

    private Httphelper httpHelper;
    public RegisterController() {

    }

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private DatePicker birthDate;
    @FXML
    private PasswordField password;
    @FXML
    private Button createButton;
    @FXML
    private Label wrongPassword;

    private void checkCreate() throws IOException {
        DiscordoApp m = new DiscordoApp();

        String prenom = firstName.getText();
        String nom = lastName.getText();
        String mail = username.getText();
        String pwd = password.getText();
        //String dateNaissance = birthDate.getDayCellFactory().toString();
        String dateNaissance = "le petit Jésus 3000 on s'en bat les roubignolles";

        if (!mail.equals("") && !pwd.equals("") && !prenom.equals("") && !nom.equals("") && !dateNaissance.equals("")) {
            try {
                String reponse = httpHelper.createUser(prenom, nom, mail, pwd, dateNaissance);
                System.out.println(reponse);
                if (reponse != null && !reponse.equals("")) {
                    m.changeScene("Login.fxml");
                }
                else {wrongPassword.setText("Mail deja utilisé");}
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (mail.equals("") && pwd.equals("") && prenom.equals("") && nom.equals("") && dateNaissance.equals("")) {
            wrongPassword.setText("Veuillez remplir les champs");
        }
        else {
            if(mail.equals("")) {
                wrongPassword.setText("Veuillez saisir une adresse e-mail");
            }
            if(pwd.equals("")) {
                wrongPassword.setText("Veuillez saisir un mot de passe");
            }
            if(prenom.equals("")) {
                wrongPassword.setText("Veuillez saisir un prenom");
            }
            if(nom.equals("")) {
                wrongPassword.setText("Veuillez saisir un nom");
            }
            if(dateNaissance.equals("")) {
                wrongPassword.setText("Veuillez saisir une date de naissance");
            }
        }
    }

    public void userCreation() throws IOException {
        checkCreate();
    }

}
