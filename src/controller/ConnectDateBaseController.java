/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.VR_Project.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import plagin.DateBase;
import plagin.Face;

/**
 * FXML Controller class
 *
 * @author shareef_ragab
 */
public class ConnectDateBaseController implements Initializable {

    //<editor-fold defaultstate="collapsed" desc="varible">
    private static ConnectDateBaseController classConnect;
    private static final Logger LOG = Logger.getLogger(ConnectDateBaseController.class.getName());

    /**
     * @return the classConnect
     */
    public static ConnectDateBaseController getClassConnect() {
        return classConnect;
    }

    /**
     * @param aClassConnect the classConnect to set
     */
    public static void setClassConnect(ConnectDateBaseController aClassConnect) {
        classConnect = aClassConnect;
    }

    /**
     * @return the LOG
     */
    public static Logger getLOG() {
        return LOG;
    }
    private String code;
    private String local;
    private String hostName;
    private String NameDateBase;
    private String userName;
    private String password;
    private String url;
    private String port;
    @FXML
    private BorderPane paFacelConnect;
    @FXML
    private ComboBox<String> coDate_Type;
    @FXML
    private TextField thAddressDB;
    @FXML
    private TextField thNameDB;
    @FXML
    private TextField thUserDB;
    @FXML
    private Spinner<Integer> thPortDB;
    @FXML
    private PasswordField thPasswordDB;
    @FXML
    private Button botTest;
    @FXML
    private Button botOpen;
    @FXML
    private Label laTest;
//</editor-fold>

    public ConnectDateBaseController() {
        //<editor-fold defaultstate="collapsed" desc="statment">
        assert paFacelConnect != null : "fx:id=\"paFacelConnect\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert coDate_Type != null : "fx:id=\"coDate_Type\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert thAddressDB != null : "fx:id=\"thAddressDB\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert thPortDB != null : "fx:id=\"thPortDB\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert thNameDB != null : "fx:id=\"thNameDB\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert thUserDB != null : "fx:id=\"thUserDB\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert thPasswordDB != null : "fx:id=\"thPasswordDB\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert botTest != null : "fx:id=\"botTest\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert laTest != null : "fx:id=\"laTest\" was not injected: check your FXML file 'connectDateBase.fxml'.";
        assert botOpen != null : "fx:id=\"botOpen\" was not injected: check your FXML file 'connectDateBase.fxml'.";
//</editor-fold>
    }

    public ConnectDateBaseController(DateBase db) throws SQLException, IOException {
        this();
        //<editor-fold defaultstate="collapsed" desc="statment">
        File filedb = new File(getPATHPARENT() + "/table.sql");
        if (!filedb.exists()) {
            try (FileWriter weite = new FileWriter(filedb)) {
                String codedb = "CREATE TABLE info_conn_database (\n"
                        + "  Port int NOT NULL,\n"
                        + "  local varchar(45) NOT NULL,\n"
                        + "  hostName varchar(45) NOT NULL,\n"
                        + "  codeData varchar(45) NOT NULL,\n"
                        + "  nameDataBase varchar(45) NOT NULL,\n"
                        + "  userName_DB varchar(45) DEFAULT NULL,\n"
                        + "  Password_DB varchar(45) DEFAULT NULL)";
                weite.append(codedb);
                db.setPst(db.getConn().prepareStatement(codedb));
                db.getPst().execute();
                weite.flush();
                codedb = "  CREATE TABLE info_log (\n"
                        + "  ID_user varchar(45) NOT NULL,\n"
                        + "  email varchar(45) NOT NULL,\n"
                        + "  password varchar(45) DEFAULT NULL)";
                weite.append(codedb);
                db.setPst(db.getConn().prepareStatement(codedb));
                db.getPst().execute();
                weite.flush();
            }
        }

        //</editor-fold>
    }

    //<editor-fold defaultstate="collapsed" desc="statment">
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the hostName
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * @param hostName the hostName to set
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * @return the NameDateBase
     */
    public String getNameDateBase() {
        return NameDateBase;
    }

    /**
     * @param NameDateBase the NameDateBase to set
     */
    public void setNameDateBase(String NameDateBase) {
        this.NameDateBase = NameDateBase;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }
//</editor-fold>

    @FXML
    private void onActionBotOpen(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        try {

            getClassTempDB().setPst(getClassTempDB().getConn().prepareStatement("INSERT INTO info_conn_database\n"
                    + "(Port,local,hostName,codeData,nameDataBase,userName_DB,Password_DB)\n"
                    + "VALUES (?,?,?,?,?,?,?)"));
            getClassTempDB().getPst().setString(1, getPort());
            getClassTempDB().getPst().setString(2, getLocal());
            getClassTempDB().getPst().setString(3, getHostName());
            getClassTempDB().getPst().setString(4, getCode());
            getClassTempDB().getPst().setString(5, getNameDateBase());
            getClassTempDB().getPst().setString(6, getUserName());
            getClassTempDB().getPst().setString(7, getPassword());
            getClassTempDB().getPst().execute();
            setPageView(Face.FaceWelcome, true);
        } catch (SQLException ex) {
            getClassTools().MadicException(ex, "0x102640244^0001", getLOG(), getClassDB(), null, true);
        } catch (Exception ex) {
            getClassTools().MadicException(ex, "1x102640244^0001", getLOG(), getClassDB(), null, true);
        }
//</editor-fold>
    }

    @FXML
    private void onActionBotTest(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        try {
            switch (coDate_Type.getSelectionModel().getSelectedIndex()) {
                case 0:
                    setCode("jdbc:mysql");
                    setLocal("com.mysql.jdbc.Driver");
                    break;
                default:
                    setCode("");
                    setLocal("");
                    break;
            }
            setHostName(thAddressDB.getText());
            setPassword(thPasswordDB.getText());
            setNameDateBase(thNameDB.getText());
            setPort(thPortDB.getValue().toString());
            setUrl(getCode() + "://" + getHostName() + ":" + getPort() + "/" + getNameDateBase());
            setUserName(thUserDB.getText());
            setClassDB(new DateBase(getLocal(), getUrl(), getNameDateBase(), getHostName(), getPort(), getUserName(), getPassword()));
            laTest.setText(getResLang().getString("Massega.label.secsessfel.connect"));
            botOpen.setDisable(false);
        } catch (ClassNotFoundException | SQLException ex) {
            laTest.setText(getResLang().getString("Massega.label.fail.connect"));
            getClassTools().MadicException(ex, "0x102960275^0001", getLOG(), null, null, true);
        }
//</editor-fold>

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
        //<editor-fold defaultstate="collapsed" desc="statment">
        try {
            coDate_Type.getItems().addAll("MySQl قاعدة بينات");
            coDate_Type.getSelectionModel().select(0);
            getClassTools().setSpanner(thPortDB, 1025, 8000, 3306);
            new ConnectDateBaseController(getClassTempDB());
        } catch (SQLException | IOException ex) {
            getClassTools().MadicException(ex, "0x203180314^0001", getLOG(), null, null, true);
        } catch (Exception ex) {
            getClassTools().MadicException(ex, "1x203180314^0001", getLOG(), null, null, true);
        }
//</editor-fold>
    }

}
