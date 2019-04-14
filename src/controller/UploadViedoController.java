/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.VR_Project.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author shareef_ragab
 */
public class UploadViedoController implements Initializable {

    @FXML
    private TextField text_nameViedo, text_path_viedo, text_path_discrption;

    @FXML
    private ProgressBar progresPathviedo, progresPathDicrptionViedo;

    @FXML
    private Label laStateUploadPathViedo, laStatePathDecrption;
    private FileChooser chooser;

    @FXML
    void onActionUploadPathviedo(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statmrent">
        try {
            chooser = new FileChooser();
            getClassTools().setFile(null, chooser, getResLang().getString("Massega.chooser.Discrption.viedo"), getResLang().getString("Massega.chooser.title"), "*.MP4", "*.3GP");
            if (getClassTools().getFile() != null) {
                text_path_viedo.setUserData(getClassTools().copyFile(getClassTools().getFile().getPath(), getPATHPARENT() + "\\fileViedo", progresPathviedo));
                text_path_viedo.setText(getClassTools().getFile().getPath());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadViedoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadViedoController.class.getName()).log(Level.SEVERE, null, ex);
        }
//</editor-fold>
    }

    @FXML
    void onActionpath_Descrption(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statmrent">
        try {
            chooser = new FileChooser();
            getClassTools().setFile(null, chooser, getResLang().getString("Massega.chooser.Discrption.webDicrption_viedo"), getResLang().getString("Massega.chooser.title"), "*.htm", "*.html");
            if (getClassTools().getFile() != null) {
                text_path_discrption.setUserData(getClassTools().copyFile(getClassTools().getFile().getPath(), getPATHPARENT() + "\\fileDicrotionViedo", progresPathDicrptionViedo));
                text_path_discrption.setText(getClassTools().getFile().getPath());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadViedoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadViedoController.class.getName()).log(Level.SEVERE, null, ex);
        }
//</editor-fold>
    }

    @FXML
    void onActionfinsh(ActionEvent event) {
        try {
            TextField[] text = new TextField[]{text_nameViedo, text_path_viedo, text_path_discrption};
            for (TextField in : text) {
                if (in.getText().isEmpty()) {
                    throw new Exception(getResLang().getString("Massega.show.text.empity_text"));

                }
            }
            if (text_nameViedo.getText().matches("[a-zA-Z]*")) {
                text = new TextField[]{text_path_viedo, text_path_discrption};
                for (TextField in : text) {
                    new File((String) in.getUserData() + File.separator + new File(in.getText()).getName()).renameTo(new File((String) in.getUserData() + File.separator + text_nameViedo.getText()));
                }
            } else {
                getClassTools().showMasseg(Alert.AlertType.INFORMATION, getResLang().getString("Massega.show.text.name_error_wreate"), getResLang().getString("Massega.header.info"), getResLang().getString("Massega.titel.massege"));
            }
        } catch (Exception ex) {
            getClassTools().showMasseg(Alert.AlertType.WARNING, ex.getMessage(), getResLang().getString("Massega.header.info"), getResLang().getString("Massega.titel.massege"));
        }
    }

    @FXML
    void initialize() {
        //<editor-fold defaultstate="collapsed" desc="statment">
        assert text_nameViedo != null : "fx:id=\"text_nameViedo\" was not injected: check your FXML file 'uploadViedo.fxml'.";
        assert text_path_viedo != null : "fx:id=\"text_path_viedo\" was not injected: check your FXML file 'uploadViedo.fxml'.";
        assert text_path_discrption != null : "fx:id=\"text_path_discrption\" was not injected: check your FXML file 'uploadViedo.fxml'.";
        assert laStateUploadPathViedo != null : "fx:id=\"laStateUploadPathViedo\" was not injected: check your FXML file 'uploadViedo.fxml'.";
        assert laStatePathDecrption != null : "fx:id=\"laStatePathDecrption\" was not injected: check your FXML file 'uploadViedo.fxml'.";
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
        // TODO

    }

}
