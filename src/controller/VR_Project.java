/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.wolf.java.ConnectDateBase;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modeltion.Face;
import com.wolf.javaFx.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import modeltion.VR_DataBase;

/**
 *
 * @author shareef_ragab
 */
public class VR_Project extends Application {

    //<editor-fold defaultstate="collapsed" desc="varible">
    private static DateBase classDB, classTempDB;
    private static VR_Project classVR_Project;
    private static String PATHPARENT, ID_SEISSION;
    private static Tools classTools;
    private static ResourceBundle resLang;
    private static Parent root;
    private static Scene scene;
    private static Stage stage;
    private static URL pathFace;
    private static Face face;
    private static ConnectDateBase conn;
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="set & get">

    public static String getID_SEISSION() {
        return ID_SEISSION;
    }

    public static void setID_SEISSION(String ID_SEISSION) {
        VR_Project.ID_SEISSION = ID_SEISSION;
    }

    public static VR_Project getClassVR_Project() {
        return classVR_Project;
    }

    private static void setClassVR_Project(VR_Project classVR_Project) {
        VR_Project.classVR_Project = classVR_Project;
    }

    private static void setFace(Face face) {
        VR_Project.face = face;
    }

    public static URL getPathFace() {
        return pathFace;
    }

    public static void setPathFace(URL pathFace) {
        VR_Project.pathFace = pathFace;
    }

    public static Parent getRoot() {
        return root;
    }

    public static void setRoot(Parent root) {
        VR_Project.root = root;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        VR_Project.scene = scene;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        VR_Project.stage = stage;
    }

    public static Tools getClassTools() {
        return classTools;
    }

    public static void setClassTools(Tools classTools) {
        VR_Project.classTools = classTools;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static DateBase getClassDB() {
        return classDB;
    }

    public static void setClassDB(DateBase classDB) {
        VR_Project.classDB = classDB;
    }

    public static DateBase getClassTempDB() {
        return classTempDB;
    }

    public static void setClassTempDB(DateBase classTempDB) {
        VR_Project.classTempDB = classTempDB;
    }

    public static ResourceBundle getResLang() {
        return resLang;
    }

    public static void setResLang(ResourceBundle aResLang) {
        resLang = aResLang;
    }

    public static String getPATHPARENT() {
        return PATHPARENT;
    }

    public static Face getFace() {
        return face;
    }

//</editor-fold>
    public static void setPageView(Face face, final boolean isOutshow) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="statment">
        setFace(face);
        if ((getStage() != null && isOutshow) && conn.isVisible()) {
            getStage().close();
        }
        switch (getFace()) {
            case FaceWelcome:
                VR_Project.setPathFace(getClassVR_Project().getClass().getResource("/fxml/FaceWelcome.fxml"));
                break;
            case ConnectDateBase:
                conn.setVisible(true);
                break;
            case PageCenter:
                VR_Project.setPathFace(getClassVR_Project().getClass().getResource("/fxml/PageCenter.fxml"));
                break;
            case workbench:
                VR_Project.setPathFace(getClassVR_Project().getClass().getResource("/fxml/workbench.fxml"));
                break;
            case uploadViedo:
                VR_Project.setPathFace(getClassVR_Project().getClass().getResource("/fxml/uploadViedo.fxml"));
                break;
        }
        if (!conn.isVisible()) {
            setRoot(FXMLLoader.load(getPathFace(), getResLang()));
            if (isOutshow) {
                setScene(new Scene(getRoot()));
                getStage().setScene(getScene());
                getStage().setTitle(getClassTools().getNameSystem());
                getStage().setOnCloseRequest((WindowEvent event) -> {
                    switch (getClassTools().showMasseg(Alert.AlertType.CONFIRMATION, getResLang().getString("Massega.show.text.do_Exsit"), getResLang().getString("Massega.header.info"), getResLang().getString("Massega.titel.massege"), ButtonType.YES, ButtonType.CANCEL).getButtonData()) {
                        case YES:
                            getStage().close();
                            conn.dispose();
                            break;
                        default:

                            break;
                    }
                });
                getStage().show();
            }
        }
//</editor-fold>
    }

    @Override
    public void init() throws Exception {
        //<editor-fold defaultstate="collapsed" desc="statment">
        setResLang(ResourceBundle.getBundle("lang.VR_porject", Locale.ROOT));
        classTools = new Tools(getResLang().getString("FaceWelcome.label.class_room"));
        PATHPARENT = getClassTools().getPath(getClassTools().getNameSystem(), "VR_Project");
        setClassVR_Project(this);
        classDB = new DateBase();
        face = Face.FaceWelcome;
        conn = new ConnectDateBase() {
            @Override
            public void codeAfterOpen() {
                try {
                    if (getFiledb().exists()) {
                        setWritedb(new FileWriter(getFiledb()));
                        String conect = "create table info_log("
                                + "ID_user varchar(45),"
                                + "user_name varchar(100) ,"
                                + "password_user varchar(100) )";
                        getWritedb().write(conect);
                        getWritedb().flush();
                        getWritedb().close();
                        this.getClassDB().setPst(this.getClassDB().getConn().prepareStatement(conect));
                        this.getClassDB().getPst().execute();
                    }
                    this.setVisible(false);
                    VR_Project.setClassDB(this.getDBInfo());
                    new VR_DataBase(this.getDBInfo());
                    Platform.runLater(() -> {
                        try {
                            setPageView(Face.FaceWelcome, true);
                        } catch (Exception ex) {
                            Logger.getLogger(VR_Project.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                } catch (SQLException ex) {
                    Logger.getLogger(VR_Project.class.getName()).log(Level.SEVERE, null, ex);
                    Platform.runLater(() -> {
                        getStage().close();
                    });
                } catch (IOException ex) {
                    Logger.getLogger(VR_Project.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        setClassTempDB(conn.getClassDB());
        if (conn.getFiledb().exists()) {
            if (getClassTempDB().setCuroser("select * from info_conn_database")) {
                setClassDB(new DateBase(getClassTempDB().getRs().getString("local"),
                        getClassTempDB().getRs().getString("codeData") + "://" + getClassTempDB().getRs().getString("hostName") + ":" + getClassTempDB().getRs().getString("Port") + "/" + getClassTempDB().getRs().getString("nameDataBase"),
                        getClassTempDB().getRs().getString("nameDataBase"), getClassTempDB().getRs().getString("hostName"),
                        getClassTempDB().getRs().getString("Port"), getClassTempDB().getRs().getString("userName_DB"),
                        getClassTempDB().getRs().getString("Password_DB")));
            } else {
                face = Face.ConnectDateBase;
            }
        } else {
            face = Face.ConnectDateBase;
        }
//</editor-fold>
    }

    @Override
    public void start(Stage stage) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="statment">
        setStage(stage);
        switch (getFace()) {
            case FaceWelcome:
                setPathFace(getClass().getResource("/fxml/FaceWelcome.fxml"));
                if (getClassTempDB().setCuroser("SELECT * FROM info_log")) {
                    getClassDB().setPst(getClassDB().getConn().prepareStatement("CALL `add_log`(?, ?, ?, ?);"));
                    getClassDB().getPst().setString(1, getClassTempDB().getRs().getString("ID_user"));
                    getClassDB().getPst().setString(2, getClassTempDB().getRs().getString("user_name"));
                    getClassDB().getPst().setString(3, getClassTempDB().getRs().getString("password_user"));
                    getClassDB().getPst().setString(4, getClassTools().getInfoNetworkInterface(NetworkInterface.getByInetAddress(InetAddress.getLocalHost())));
                    getClassDB().getPst().execute();
                    setID_SEISSION(getClassTempDB().getRs().getString("ID_user"));
                    setPageView(Face.uploadViedo, true);
                }
                break;
            case ConnectDateBase:

                conn.setVisible(true);
                break;
            case PageCenter:
                setPathFace(getClass().getResource("/fxml/PageCenter.fxml"));
                break;
            case workbench:
                setPathFace(getClass().getResource("/fxml/workbench.fxml"));
                break;
            case uploadViedo:
                setPathFace(getClass().getResource("/fxml/uploadViedo.fxml"));
                break;
        }

        if (!conn.isVisible()) {
            setRoot(FXMLLoader.load(getPathFace(), getResLang()));
            setScene(new Scene(getRoot()));
            setStage(stage);
            getStage().setScene(getScene());
            getStage().setTitle(getClassTools().getNameSystem());
            getStage().setOnCloseRequest((WindowEvent event) -> {
                try {
                    switch (getClassTools().showMasseg(Alert.AlertType.CONFIRMATION, getResLang().getString("Massega.show.text.do_Exsit"), getResLang().getString("Massega.header.info"), getResLang().getString("Massega.titel.massege"), ButtonType.YES, ButtonType.CANCEL).getButtonData()) {
                        case YES:
                            if (!getID_SEISSION().isEmpty()) {
                                getClassDB().setPst(getClassDB().getConn().prepareStatement("CALL Exsit(?);"));
                                getClassDB().getPst().setString(1, getID_SEISSION());
                                getClassDB().getPst().execute();
                            }
                            getStage().close();
                            conn.dispose();
                            break;
                        default:
                            break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(VR_Project.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            getStage().show();
        }
//</editor-fold>
    }

}
