/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.VR_Project.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import plagin.Face;

/**
 * FXML Controller class
 *
 * @author shareef_ragab
 */
public class FaceWelcomeController implements Initializable {
    //<editor-fold defaultstate="collapsed" desc="varible">

    private int count_fail = 0;
    @FXML
    private PasswordField text_password, text_password_regster;

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
        //<editor-fold defaultstate="collapsed" desc="statment">
        try {
            getClassDB().setPst(getClassDB().getConn().prepareStatement("CALL `add_user`(?, ?, ?, ? ,?, ?);"));
            getClassDB().getPst().setString(1, text_user_regster.getText());
            getClassDB().getPst().setString(2, text_password_regster.getText());
            getClassDB().getPst().setString(3, text_email.getText());
            getClassDB().getPst().setString(4, text_NumPhone.getText());
            getClassTools().getSelect(radi_techer, redi_student, getClassDB().getPst(), 5);
            getClassTools().getSelect(radi_Male, radio_Female, getClassDB().getPst(), 6);
            getClassDB().getPst().execute();
        } catch (SQLException ex) {
            Logger.getLogger(FaceWelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
//</editor-fold>
    }

    @FXML
    private void onActionBut_login(ActionEvent event) throws Exception {
        try {
            if (!text_password.getText().isEmpty() && !text_username.getText().isEmpty()) {
                Scanner pass = new Scanner(text_password.getText());
                Scanner user = new Scanner(text_username.getText());
                String enPassword = pass.next();
                String enUserName = user.next();
                do {
                    if (getClassDB().setCuroser("Select * from show_info_log where email='" + enUserName + "' and password='" + enPassword + "' and state_log=0 ;")) {
                        setID_SEISSION(getClassDB().getRs().getString("ID_user"));
                        getClassDB().setPst(getClassDB().getConn().prepareStatement("CALL `add_log`(?, ?, ?, ?);"));
                        getClassDB().getPst().setString(1, getID_SEISSION());
                        getClassDB().getPst().setString(2, enUserName);
                        getClassDB().getPst().setString(3, enPassword);
                        getClassDB().getPst().setString(4, getClassTools().getInfoNetworkInterface(NetworkInterface.getByInetAddress(InetAddress.getLocalHost())));
                        getClassDB().getPst().execute();
                        if (check_Remmber.isSelected()) {
                            getClassTempDB().setPst(getClassTempDB().getConn().prepareStatement("INSERT INTO info_log (ID_user,email,password)VALUES(?,?,?) "));
                            getClassTempDB().getPst().setString(1, getID_SEISSION());
                            getClassTempDB().getPst().setString(2, enUserName);
                            getClassTempDB().getPst().setString(3, enPassword);
                            getClassTempDB().getPst().execute();
                        }
                        setPageView(Face.PageCenter, true);
                    } else {
                        count_fail++;
                        switch (count_fail) {
                            case 1:
                                getClassTools().showMasseg(Alert.AlertType.INFORMATION, getResLang().getString("Massega.show.text.error_password") + " " + getResLang().getString("Massega.show.text.try_agin"), getResLang().getString("Massega.header.info"), getResLang().getString("Massega.titel.massege"));
                                text_username.setText(null);
                                text_password.setText(null);
                                break;
                            case 2:
                                getClassTools().showMasseg(Alert.AlertType.INFORMATION, getResLang().getString("Massega.show.text.error_password") + " " + getResLang().getString("Massega.show.text.try_agin"), getResLang().getString("Massega.header.info"), getResLang().getString("Massega.titel.massege"));
                                text_username.setText(null);
                                text_password.setText(null);
                                break;
                            default:
                                getClassTools().showMasseg(Alert.AlertType.INFORMATION, getResLang().getString("Massega.show.text.error_password") + " " + getResLang().getString("Massega.show.text.try_agin") + " " + getResLang().getString("Massega.show.text.goBy"), getResLang().getString("Massega.header.info"), getResLang().getString("Massega.titel.massege"));
                                System.exit(0);
                                break;
                        }
                    }

                } while (count_fail < 3 && pass.hasNext());
            } else {
                getClassTools().showMasseg(Alert.AlertType.INFORMATION, getResLang().getString("Massega.show.no_date"), getResLang().getString("Massega.header.info"), getResLang().getString("Massega.titel.massege"));
            }
        } catch (SQLException | UnknownHostException | SocketException ex) {
            Logger.getLogger(FaceWelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        assert text_password_regster != null : "fx:id=\"text_password_regster\" was not injected: check your FXML file 'FaceWelcome.fxml'.";
//</editor-fold>
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

}
