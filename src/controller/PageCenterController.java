/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import static controller.VR_Project.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import modeltion.classStudy;

/**
 * FXML Controller class
 *
 * @author shareef_ragab
 */
public class PageCenterController implements Initializable {

    //<editor-fold defaultstate="collapsed" desc="varible">
    private MediaPlayer mediaPlayer;
    private ArrayList<classStudy> viedoStudy;

    @FXML
    private WebView view_Deiscreption;

    @FXML
    private MediaView showViedo;

    @FXML
    private Button btn_Prev, btn_seekPrev, btn_seeknext, btn_nextViedo;

    @FXML
    private ToggleButton togle_run;

    @FXML
    private Slider spVolViedo, spSoundViedo;

    @FXML
    private Label laNameViedo;
//</editor-fold>

    @FXML
    void onActionBtnSeelPrev(ActionEvent event) {

    }

    @FXML
    void onActionBtn_Prev(ActionEvent event) {

    }

    @FXML
    void onActionBtn_nextViedo(ActionEvent event) {

    }

    @FXML
    void onActionBtn_seekNext(ActionEvent event) {

    }

    @FXML
    void onActionTogle_Run(ActionEvent event) {

    }

    @FXML
    void initialize() {
        //<editor-fold defaultstate="collapsed" desc="statment">
        assert view_Deiscreption != null : "fx:id=\"view_Deiscreption\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert showViedo != null : "fx:id=\"showViedo\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert btn_Prev != null : "fx:id=\"btn_Prev\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert btn_seekPrev != null : "fx:id=\"btn_seekPrev\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert togle_run != null : "fx:id=\"togle_run\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert btn_seeknext != null : "fx:id=\"btn_seeknext\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert btn_nextViedo != null : "fx:id=\"btn_nextViedo\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert spVolViedo != null : "fx:id=\"spVolViedo\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert spSoundViedo != null : "fx:id=\"spSoundViedo\" was not injected: check your FXML file 'PageCenter.fxml'.";
        assert laNameViedo != null : "fx:id=\"laNameViedo\" was not injected: check your FXML file 'PageCenter.fxml'.";
//</editor-fold>
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ArrayList<String> indexwatch = new ArrayList<String>();
            viedoStudy = new ArrayList<>();
            if (getClassDB().setCuroser("select * from listfinsh where ID_USER='" + getID_SEISSION() + "';")) {
                String[] in = getClassDB().getRs().getString("listFinsh").split(":");
                for (String index : in) {
                    indexwatch.add(index);
                }
            }
            if (getClassDB().setCuroser("select * from show_info_viedo ")) {
                do {
                    if (indexwatch.contains(getClassDB().getRs().getString("ID"))) {
                        viedoStudy.add(new classStudy(getClassDB().getRs().getString("pathViedo"),
                                getClassDB().getRs().getString("DescreptionViedo"),
                                getClassDB().getRs().getString("nameViedo"),
                                getClassDB().getRs().getString("dateCreate"),
                                getClassDB().getRs().getString("user_name") + ":" + getClassDB().getRs().getString("email")));
                    }
                } while (getClassDB().getRs().next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PageCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
