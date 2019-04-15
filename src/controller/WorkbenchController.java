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
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author shareef_ragab
 */
public class WorkbenchController implements Initializable {

    //<editor-fold defaultstate="collapsed" desc="varible">
    @FXML
    private AnchorPane paFaceWorkBench;
    
    @FXML
    private Accordion viewPlag;
    
    @FXML
    private Label laUserName;
    
    @FXML
    private Label laUserAge;
    
    @FXML
    private Label laDateBarth;
    
    @FXML
    private Label laGender;
    
    @FXML
    private Label laId_User;
    
    @FXML
    private Label laEmail;
    
    @FXML
    private Label laAddress;
    
    @FXML
    private Label laPhoneNum;
    
    @FXML
    private Hyperlink linekRePassword;
    
    @FXML
    private TitledPane titActive;
    
    @FXML
    private ListView<?> listIcon;
    
    @FXML
    private Button botRefresh;
    
    @FXML
    private TitledPane titListChat;
    
    @FXML
    private ListView<?> listChat;
    
    @FXML
    private Button botRefreshListMasse;
    
    @FXML
    private TitledPane titChat;
    
    @FXML
    private Label laUserActiveDest;
    
    @FXML
    private ImageView imgUserChar;
    
    @FXML
    private Button botRefeshMasseg;
    
    @FXML
    private TextField thSendMasseg;
    
    @FXML
    private Button botSendMassegebotSendMassege;
    
    @FXML
    private ListView<?> listViewMassege;
    
    @FXML
    private Button botSerch;
    
    @FXML
    private TextField thSearch;
    
    @FXML
    private BorderPane paFace;
//</editor-fold>

    @FXML
    void OnActionBotSendMassegebotSendMassege(ActionEvent event) {
        
    }
    
    @FXML
    void OnMouseClickedListUserActive(MouseEvent event) {
        
    }
    
    @FXML
    void botSerchActionPerformed(ActionEvent event) {
        
    }
    
    @FXML
    void onActionBotRefreshListMasse(ActionEvent event) {
        
    }
    
    @FXML
    void onActionBotRefreshMasseg(ActionEvent event) {
        
    }
    
    @FXML
    void onActionLiinkrePassword(ActionEvent event) {
        
    }
    
    @FXML
    void onActionbotRefresh(ActionEvent event) {
        
    }
    
    @FXML
    void onMouseClickedListChat(MouseEvent event) {
        
    }
    
    @FXML
    void initialize() {
        //<editor-fold defaultstate="collapsed" desc="statment">
        assert paFaceWorkBench != null : "fx:id=\"paFaceWorkBench\" was not injected: check your FXML file 'workbench.fxml'.";
        assert viewPlag != null : "fx:id=\"viewPlag\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laUserName != null : "fx:id=\"laUserName\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laUserAge != null : "fx:id=\"laUserAge\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laDateBarth != null : "fx:id=\"laDateBarth\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laGender != null : "fx:id=\"laGender\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laId_User != null : "fx:id=\"laId_User\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laEmail != null : "fx:id=\"laEmail\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laAddress != null : "fx:id=\"laAddress\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laPhoneNum != null : "fx:id=\"laPhoneNum\" was not injected: check your FXML file 'workbench.fxml'.";
        assert linekRePassword != null : "fx:id=\"linekRePassword\" was not injected: check your FXML file 'workbench.fxml'.";
        assert titActive != null : "fx:id=\"titActive\" was not injected: check your FXML file 'workbench.fxml'.";
        assert listIcon != null : "fx:id=\"listIcon\" was not injected: check your FXML file 'workbench.fxml'.";
        assert botRefresh != null : "fx:id=\"botRefresh\" was not injected: check your FXML file 'workbench.fxml'.";
        assert titListChat != null : "fx:id=\"titListChat\" was not injected: check your FXML file 'workbench.fxml'.";
        assert listChat != null : "fx:id=\"listChat\" was not injected: check your FXML file 'workbench.fxml'.";
        assert botRefreshListMasse != null : "fx:id=\"botRefreshListMasse\" was not injected: check your FXML file 'workbench.fxml'.";
        assert titChat != null : "fx:id=\"titChat\" was not injected: check your FXML file 'workbench.fxml'.";
        assert laUserActiveDest != null : "fx:id=\"laUserActiveDest\" was not injected: check your FXML file 'workbench.fxml'.";
        assert imgUserChar != null : "fx:id=\"imgUserChar\" was not injected: check your FXML file 'workbench.fxml'.";
        assert botRefeshMasseg != null : "fx:id=\"botRefeshMasseg\" was not injected: check your FXML file 'workbench.fxml'.";
        assert thSendMasseg != null : "fx:id=\"thSendMasseg\" was not injected: check your FXML file 'workbench.fxml'.";
        assert botSendMassegebotSendMassege != null : "fx:id=\"botSendMassegebotSendMassege\" was not injected: check your FXML file 'workbench.fxml'.";
        assert listViewMassege != null : "fx:id=\"listViewMassege\" was not injected: check your FXML file 'workbench.fxml'.";
        assert botSerch != null : "fx:id=\"botSerch\" was not injected: check your FXML file 'workbench.fxml'.";
        assert thSearch != null : "fx:id=\"thSearch\" was not injected: check your FXML file 'workbench.fxml'.";
        assert paFace != null : "fx:id=\"paFace\" was not injected: check your FXML file 'workbench.fxml'.";
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
