package org.waa.sme.scenebuilder;

import javafx.scene.control.*;
import org.waa.sme.utils.IdSingleton;
import org.waa.sme.utils.Httphelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.*;

public class RegisterController {

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
    private Button registerButton;

}
