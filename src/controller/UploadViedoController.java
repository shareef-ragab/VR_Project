/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.VR_Project.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private Label laStateUploadPathViedo, laStatePathDecrption;
    private FileChooser chooser;

    @FXML
    void onActionUploadPathviedo(ActionEvent event) {
        try {
            getClassTools().setFile(getStage(), chooser, getResLang().getString("Massega.chooser.Discrption.viedo"), getResLang().getString("Massega.chooser.title"), "*.MP4", "*.3GP");
            if(getClassTools().getFile()!=null){
                getClassTools().copyFile(getClassTools().getFile().getPath(), getPATHPARENT()+"\\fileViedo\\"+text_nameViedo.getText()+".mp4");
                text_path_viedo.setText(getClassTools().getFile().getPath());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UploadViedoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UploadViedoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void onActionpath_Descrption(ActionEvent event) {

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
        chooser = new FileChooser();
    }

}
