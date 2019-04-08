/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import plagin.DateBase;
import plagin.Face;
import plagin.Tools;

/**
 *
 * @author shareef_ragab
 */
public class VR_Project extends Application {

    private static DateBase classDB, classTempDB;
    private static String PATHPARENT;
    private static Tools classTools;
    private static ResourceBundle resLang;
    private static Parent root;
    private static Scene scene;
    private static Stage stage;
    private static URL pathFace;
    private static Face face;
    //<editor-fold defaultstate="collapsed" desc="set & get">

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
    @Override
    public void init() throws Exception {
        classDB = new DateBase();
        face = Face.ConnectDateBase;
        setResLang(ResourceBundle.getBundle("lang.Arebic_WorkBench", Locale.ROOT));
        classTools = new Tools(getResLang().getString("FaceWelcome.label.class_room"));
        PATHPARENT = getClassTools().getPath(getClassTools().getNameSystem(), "VR_Project");
        setClassTempDB(new DateBase("", "jdbc:derby:" + getPATHPARENT() + "/APP;create=true", "", ""));
        if (new File(getPATHPARENT() + "/table.sql").exists()) {
            if (getClassTempDB().setCuroser("select * from info_conn_database")) {
                setClassDB(new DateBase(getClassTempDB().getRs().getString("local"),
                        getClassTempDB().getRs().getString("codeData") + "://" + getClassTempDB().getRs().getString("hostName") + ":" + getClassTempDB().getRs().getString("Port") + "/" + getClassTempDB().getRs().getString("nameDataBase"),
                        getClassTempDB().getRs().getString("nameDataBase"), getClassTempDB().getRs().getString("hostName"),
                        getClassTempDB().getRs().getString("Port"), getClassTempDB().getRs().getString("userName_DB"),
                        getClassTempDB().getRs().getString("Password_DB")));
            } else {

            }
        } else {

        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        switch (face) {
            case FaceWelcome:
                setPathFace(getClass().getResource("/fxml/FaceWelcome.fxml"));
                break;
            case ConnectDateBase:
                setPathFace(getClass().getResource("/fxml/connectDateBase.fxml"));
                break;
            case PageCenter:
                setPathFace(getClass().getResource("/fxml/PageCenter.fxml"));
                break;
            case workbench:
                setPathFace(getClass().getResource("/fxml/workbench.fxml"));
                break;
        }

        setRoot(FXMLLoader.load(getPathFace(), getResLang()));
        setScene(new Scene(getRoot()));
        setStage(stage);
        getStage().setScene(scene);
        getStage().show();
    }

}
