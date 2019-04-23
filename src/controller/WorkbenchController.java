/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.wolf.javaFx.DateBase;
import static controller.VR_Project.*;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modeltion.VR_DataBase.*;

/**
 * FXML Controller class
 *
 * @author shareef_ragab
 */
public class WorkbenchController implements Initializable {

    //<editor-fold defaultstate="collapsed" desc="varible">
    private static DateBase classDBChat = new DateBase();
    private static String id_chat;
    private static int count_ActiveUser = 0;
    /**
     * @return the count_ActiveUser
     */
    public static int getCount_ActiveUser() {
        return count_ActiveUser;
    }
    /**
     * @param aCount_ActiveUser the count_ActiveUser to set
     */
    public static void setCount_ActiveUser(int aCount_ActiveUser) {
        count_ActiveUser = aCount_ActiveUser;
    }

    @FXML
    private AnchorPane paFaceWorkBench;

    @FXML
    private Accordion viewPlag;

    @FXML
    private Label laData, laUserName, laUserAge, laDateBarth, laGender, laId_User, laEmail, laAddress, laPhoneNum;

    @FXML
    private Hyperlink linekRePassword;

    @FXML
    private TitledPane titActive, titListChat, titChat;

    @FXML
    private ListView<Label> listIcon, listChat, listViewMassege;

    @FXML
    private Button botRefresh, botRefreshListMasse, botSendMassegebotSendMassege, botSerch, botRefeshMasseg;

    @FXML
    private Label laUserActiveDest;

    @FXML
    private ImageView imgUserChar;

    @FXML
    private TextField thSendMasseg, thSearch;

    @FXML
    private Text laTime;

    @FXML
    private BorderPane paFace;
    //<editor-fold defaultstate="collapsed" desc="thread">
    private final Runnable runnableTime = () -> {
        //<editor-fold defaultstate="collapsed" desc="statment">
        while (true) {
            try {
                laTime.setText("الوقت : " + getClassTools().getTime());
                laData.setText("التاريخ : " + getClassTools().getDate());
                //setClassDB(new DataBase(DataBase.getLocal(), DataBase.getUrl(), DataBase.getUser(), DataBase.getPassword()));
                sleep(600);
            } catch (IllegalStateException | InterruptedException ex) {
                Logger.getLogger(VR_Project.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(VR_Project.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//</editor-fold>
    };

    private final Runnable runnablListMassege = () -> {
        //<editor-fold defaultstate="collapsed" desc="statment">
        while (true) {
            try {
                classDBChat = new DateBase(getClassDB().getLocal(), getClassDB().getUrl(), getClassDB().getUser(), getClassDB().getPassword());
                if (classDBChat.setCuroser("SELECT count(" + Chat.getReadChat() + ") as 'countMasseg' FROM " + Chat.getNameTable() + " where " + Chat.getReadChat() + "='0' and " + Chat.getID_chat() + "='" + id_chat + "';")) {
                    int count = Integer.parseInt(classDBChat.getRs().getString("countMasseg"));
                    if (getCount_ActiveUser() != count) {
                        setCount_ActiveUser(count);
                        botRefeshMasseg.fire();
                    }
                }
                sleep(1000);
            } catch (IllegalStateException | InterruptedException ex) {

            } catch (Exception ex) {

            }
        }
//</editor-fold>
    };
//</editor-fold>
//</editor-fold>

    private void reListChat(ListView<Label> listview) throws SQLException, ClassNotFoundException, IOException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        ObservableList<Label> ItemLiset = FXCollections.observableArrayList();
        if (getClassDB().setCuroser("SELECT distinct " + Chat.getID_chat() + " FROM " + Chat.getNameTable() + "  where " + Chat.getID_chat() + " like '" + getID_SEISSION() + "_%' or " + Chat.getID_chat() + " like '%_" + getID_SEISSION() + "'  order by " + Chat.getDateSend() + " desc  ;")) {
            do {
                String idCh = getClassDB().getRs().getString(Chat.getID_chat());
                classDBChat.setCuroser("SELECT * FROM view_chat where " + Chat.getID_chat() + "='" + idCh + "' ;");
                String nameSend = "أنت";
                String nameChat = classDBChat.getRs().getString("user_Name_ar_dest");
                getClassTools().setInput(getClass().getResourceAsStream("/drawble/User.jpg"));
                ImageView img = new ImageView(new Image(getClassTools().getInput(), 18, 18, true, true));
                String nameJob = classDBChat.getRs().getString("NAME_JOB_Dest");
                if (classDBChat.getRs().getString("ID_DestChat").equals(getID_SEISSION())) {
                    nameChat = classDBChat.getRs().getString("user_Name_ar_sours");
                    getClassTools().setInput(getClass().getResourceAsStream("/drawble/User.jpg"));
                    img = new ImageView(new Image(getClassTools().getInput(), 18, 18, true, true));
                    nameJob = classDBChat.getRs().getString("NAME_JOB_sourse");
                }
                VBox con = new VBox();
                Label laNameJob = new Label(nameJob);
                laNameJob.setFont(new Font(8));
                laNameJob.setPrefSize(235, 8);
                laNameJob.setAlignment(Pos.CENTER_RIGHT);
                con.getChildren().add(0, laNameJob);
                Label laAbove = new Label(nameChat, img);
                laAbove.setAlignment(Pos.CENTER_LEFT);
                con.getChildren().add(1, laAbove);
                Label read = new Label((!classDBChat.getRs().getBoolean(Chat.getReadChat())) ? "غير مقروءة" : "مقروء");
                read.setFont(new Font(8));
                read.setAlignment(Pos.CENTER_LEFT);
                Label laDown = new Label(nameSend + " :" + classDBChat.getRs().getString(Chat.getTextSender()), read);
                laDown.setContentDisplay(ContentDisplay.RIGHT);
                laDown.setAlignment(Pos.CENTER_LEFT);
                laDown.setPrefWidth(155);
                Label labelDown = new Label(classDBChat.getRs().getString(Chat.getDateSend()).trim(), laDown);
                labelDown.setWrapText(true);
                labelDown.setAlignment(Pos.CENTER_RIGHT);
                labelDown.setFont(new Font(8));
                labelDown.setPadding(new Insets(5, 0, 5, 0));
                con.getChildren().add(2, labelDown);
                ItemLiset.add(getClassTools().List("", con, classDBChat.getRs().getString(Chat.getID_chat()), NodeOrientation.INHERIT, Pos.CENTER));
            } while (getClassDB().getRs().next());
        }
        listview.setItems(ItemLiset);
        //</editor-fold>
    }

    private void reListImage(ListView<Label> listview) throws SQLException, URISyntaxException, IOException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        ObservableList<Label> Item = FXCollections.observableArrayList();
        getClassDB().setRs(getClassDB().getStat().executeQuery("select  distinct Full_Name," + Info_user.getCol_ID_user() + " from show_info where " + Info_user.getCol_state_log() + "='1';"));
        while (getClassDB().getRs().next()) {
            getClassTools().setInput(getClass().getResourceAsStream("/drawble/User.jpg"));
            HBox con = new HBox();
            String name = getClassDB().getRs().getString("Full_Name");

            Label laImage = new Label(name, new ImageView(new Image(getClassTools().getInput(), 18, 18, true, true)));
            laImage.setPrefWidth(200);
            con.getChildren().add(0, laImage);
            String id = getClassDB().getRs().getString(Info_user.getCol_ID_user());
            classDBChat.setCuroser("SELECT count(" + Chat.getReadChat() + ") as'NotRead' FROM " + Chat.getNameTable() + " where " + Chat.getReadChat() + "=0  and " + Chat.getID_SenderChat() + "='" + id + "' and " + Chat.getID_DestChat() + "='" + getID_SEISSION() + "';");
            Label laIcon = new Label((classDBChat.getRs().getString("NotRead").equals("0") ? " " : classDBChat.getRs().getString("NotRead")), new ImageView(new Image(getClass().getClassLoader().getResource("com/zeroSystem/javefx/Drwable/notfiction.png").toURI().toString(), 18, 18, true, true)));
            laIcon.setContentDisplay(ContentDisplay.RIGHT);
            con.getChildren().add(1, laIcon);
            Item.add(getClassTools().List("", con, id, NodeOrientation.INHERIT, Pos.CENTER));
        }
        listview.setItems(Item);
        //</editor-fold>
    }

    private void reMasseglist(ListView<Label> listview, String idCat) throws SQLException, IOException, URISyntaxException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        ObservableList<Label> Item = FXCollections.observableArrayList();
        int x = 1;
        classDBChat.setRs(getClassDB().getStat().executeQuery("SELECT * FROM view_chat where " + Chat.getID_chat() + "='" + idCat + "' order by " + Chat.getID() + " asc;"));
        while (classDBChat.getRs().next()) {
            //<editor-fold defaultstate="collapsed" desc="statment">
            if (x == 1) {
                String name = classDBChat.getRs().getString("user_Name_dest");
                imgUserChar.setImage(new Image(getClass().getClassLoader().getResource("/drawble/User.jpg").toURI().toString(), 18, 18, true, true));
                String id = classDBChat.getRs().getString(Chat.getID_DestChat());
                if (id.equals(getID_SEISSION())) {
                    name = classDBChat.getRs().getString("user_Name_sours");
                    id = classDBChat.getRs().getString(Chat.getID_SenderChat());
                }
                laUserActiveDest.setText(name);
                laUserActiveDest.setId(id);
            }
            //</editor-fold>
            x++;
            VBox con = new VBox();
            boolean cond = classDBChat.getRs().getString(Chat.getID_Sender()).equals(getID_SEISSION());
            String idMass = classDBChat.getRs().getString(Chat.getID());
            String name = getClassDB().getRs().getString("First_Name");
            Label laMas = new Label(classDBChat.getRs().getString(Chat.getTextSender()), new Label((classDBChat.getRs().getString(Chat.getID_Sender()).equals(getID_SEISSION())) ? "أنا : " : " : " + name));
            laMas.setPrefWidth(245);
            con.getChildren().add(0, laMas);
            Button bot = new Button(null, new ImageView(new Image(getClass().getClassLoader().getResource("/drawble/trash.png").toURI().toString(), 10, 10, true, true)));
            bot.setPrefSize(10, 10);
            if (!cond) {
                bot.setVisible(false);
            }
            Label laMoriInfo = new Label(classDBChat.getRs().getString(Chat.getDateSend()), bot);
            laMoriInfo.setVisible(false);
            laMoriInfo.setFont(new Font(8));
            laMoriInfo.setGraphicTextGap(140);
            laMoriInfo.setContentDisplay(ContentDisplay.RIGHT);
            laMoriInfo.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            laMoriInfo.setPadding(new Insets(5, 0, 0, 0));
            if (!cond) {
                con.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                laMoriInfo.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            }

            laMas.setOnMouseClicked((MouseEvent event) -> {
                //<editor-fold defaultstate="collapsed" desc="statment">
                try {
                    if (!con.getChildren().contains(laMoriInfo)) {
                        con.getChildren().add(1, laMoriInfo);
                        laMoriInfo.setVisible(true);
                        if (!cond) {
                            classDBChat.setPst(classDBChat.getConn().prepareStatement("update   " + Chat.getNameTable() + " set readChat='1' where " + Chat.getID() + "='" + idMass + "';"));
                            classDBChat.getPst().execute();
                        }
                    }
                } catch (SQLException ex) {

                }
                //</editor-fold>
            });
            con.setOnMouseExited((MouseEvent event) -> {
                //<editor-fold defaultstate="collapsed" desc="statment">
                if (con.getChildren().contains(laMoriInfo)) {
                    laMoriInfo.setVisible(false);
                    con.getChildren().remove(laMoriInfo);
                }
                //</editor-fold>
            });
            bot.setOnAction((ActionEvent event) -> {
                //<editor-fold defaultstate="collapsed" desc="statment">
                try {
                    classDBChat.setPst(classDBChat.getConn().prepareStatement("delete from " + Chat.getNameTable() + " where " + Chat.getID() + "='" + idMass + "';"));
                    classDBChat.getPst().execute();
                    botRefeshMasseg.fire();
                } catch (SQLException ex) {

                }
                //</editor-fold>
            });
            Item.add(getClassTools().List(null, con, idMass, NodeOrientation.INHERIT, Pos.CENTER));
        }
        listview.setItems(Item);
        //</editor-fold>
    }

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
    void onActionShowViedo(ActionEvent event) {

    }

    @FXML
    void onActionbotRefresh(ActionEvent event) {

    }

    @FXML
    void onActionuploadviedo(ActionEvent event) {

    }

    @FXML
    void onMouseClickedListChat(MouseEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        try {
            MultipleSelectionModel<Label> selectItem = listChat.getSelectionModel();
            if (selectItem.isSelected(selectItem.getSelectedIndex())) {
                id_chat = selectItem.getSelectedItem().getId();
                viewPlag.setExpandedPane(titChat);
                reMasseglist(listViewMassege, id_chat);
                classDBChat.setPst(classDBChat.getConn().prepareStatement("update   " + Chat.getNameTable() + " set readChat='1' where " + Chat.getID_chat() + "='" + id_chat + "' and " + Chat.getID_Sender() + "='" + laUserActiveDest.getId() + "';"));
                classDBChat.getPst().execute();
            }
            new Thread(runnablListMassege).start();
        } catch (URISyntaxException | IOException | SQLException ex) {
            Logger.getLogger(VR_Project.class.getName()).log(Level.SEVERE, null, ex);
        }
//</editor-fold>
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
        classDBChat = new DateBase();
    }


}
