/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author shareef_ragab
 */
public class FaceWelcomeController implements Initializable {
    //<editor-fold defaultstate="collapsed" desc="varible">

    @FXML
    private PasswordField text_password;

    @FXML
    private TextField text_username, text_user_regster, text_email, text_NumPhone;

    @FXML
    private CheckBox check_Remmber;

    @FXML
    private Button but_login;

    @FXML
    private DatePicker date_DateBerth;

    @FXML
    private ToggleGroup GrouGENDAR;

    @FXML
    private RadioButton radio_Female, redi_student, radi_Male, radi_techer;

    @FXML
    private ToggleGroup KIndACCOUNT;
//</editor-fold>

    @FXML
    private void onActionBtn_register(ActionEvent event) {

    }

    @FXML
    private void onActionBut_login(ActionEvent event) {

    }

    @FXML
    void initialize() {
        //<editor-fold defaultstate="collapsed" desc="statment">
        assert text_password != null : "fx:id=\"text_password\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert text_username != null : "fx:id=\"text_username\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert check_Remmber != null : "fx:id=\"check_Remmber\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert but_login != null : "fx:id=\"but_login\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert text_user_regster != null : "fx:id=\"text_user_regster\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert text_email != null : "fx:id=\"text_email\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert text_NumPhone != null : "fx:id=\"text_NumPhone\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert date_DateBerth != null : "fx:id=\"date_DateBerth\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert radi_Male != null : "fx:id=\"radi_Male\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert GrouGENDAR != null : "fx:id=\"GrouGENDAR\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert radio_Female != null : "fx:id=\"radio_Female\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert redi_student != null : "fx:id=\"redi_student\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert KIndACCOUNT != null : "fx:id=\"KIndACCOUNT\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
        assert radi_techer != null : "fx:id=\"radi_techer\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
//</editor-fold>
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
