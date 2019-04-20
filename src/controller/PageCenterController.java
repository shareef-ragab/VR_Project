/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.VR_Project.*;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.util.Duration;
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
    private boolean stopRequested = false;
    private Duration duration;
    private MediaPlayer.Status status;
    private int sleedVideo;
    
    @FXML
    private ImageView img_togleRun;
    
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
        //<editor-fold defaultstate="collapsed" desc="statment">
        status = mediaPlayer.getStatus();
        if (status == MediaPlayer.Status.PLAYING || status == MediaPlayer.Status.READY) {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(Duration.millis(500)));
        }
//</editor-fold>
    }
    
    @FXML
    void onActionBtn_Prev(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        if (sleedVideo >= 1) {
            sleedVideo--;
            runMedi(sleedVideo);
        }
//</editor-fold>
    }
    
    @FXML
    void onActionBtn_nextViedo(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        if (sleedVideo < viedoStudy.size() - 1) {
            sleedVideo++;
            runMedi(sleedVideo);
        }
//</editor-fold>
    }
    
    @FXML
    void onActionBtn_seekNext(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        status = mediaPlayer.getStatus();
        if (status == MediaPlayer.Status.PLAYING || status == MediaPlayer.Status.READY) {
            
            mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.millis(500)));
        }
//</editor-fold>
    }
    
    @FXML
    void onActionTogle_Run(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        status = mediaPlayer.getStatus();
        if (status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED) {
            System.out.println("Player is in a bad or unknown state, can't play.");
            return;
        }
        if (togle_run.isSelected()) {
            img_togleRun.setImage(new Image(getClass().getResourceAsStream("/drawble/pausebutton.png")));
            if (status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.STOPPED || status == MediaPlayer.Status.READY) {
                mediaPlayer.play();
            }
        } else {
            img_togleRun.setImage(new Image(getClass().getResourceAsStream("/drawble/playbutton.png")));
            if (status == MediaPlayer.Status.PLAYING || status == MediaPlayer.Status.READY) {
                mediaPlayer.pause();
            }
        }
//</editor-fold>

    }
    
    protected void updateValues() {
        if (spVolViedo != null && spSoundViedo != null && duration != null) {
            Platform.runLater(() -> {
                Duration currentTime = mediaPlayer.getCurrentTime();
                spVolViedo.setDisable(duration.isUnknown());
                if (!spVolViedo.isDisabled() && duration.greaterThan(Duration.ZERO) && !spVolViedo.isValueChanging()) {
                    spVolViedo.setValue(currentTime.divide(duration).toMillis() * 100.0);
                }
                if (!spSoundViedo.isValueChanging()) {
                    spSoundViedo.setValue((int) Math.round(mediaPlayer.getVolume() * 100));
                }
            });
        }
    }
    
    public void runMedi(int sleedVideo) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        mediaPlayer = new MediaPlayer(new Media(new File(viedoStudy.get(sleedVideo).getPathVeido()).toURI().toString()));
        showViedo.setMediaPlayer(mediaPlayer);
        view_Deiscreption.getEngine().load(new File(viedoStudy.get(sleedVideo).getPathDiscrption()).toURI().toString());
        laNameViedo.setText(viedoStudy.get(0).getNameVeido() + "\n" + viedoStudy.get(sleedVideo).getNameAuther());
//</editor-fold>
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
        //<editor-fold defaultstate="collapsed" desc="statment">
        try {
            // TODO
            sleedVideo = 0;
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
                    if (!indexwatch.contains(getClassDB().getRs().getString("ID"))) {
                        viedoStudy.add(new classStudy(getClassDB().getRs().getString("pathViedo"),
                                getClassDB().getRs().getString("DescreptionViedo"),
                                getClassDB().getRs().getString("nameViedo"),
                                getClassDB().getRs().getString("dateCreate"),
                                getClassDB().getRs().getString("user_name") + ":" + getClassDB().getRs().getString("email")));
                    }
                } while (getClassDB().getRs().next());
            }
            runMedi(sleedVideo);
            mediaPlayer.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) -> {
                updateValues();
            });
            mediaPlayer.setOnPlaying(() -> {
                if (stopRequested) {
                    mediaPlayer.pause();
                    stopRequested = false;
                } else {
                    img_togleRun.setImage(new Image(getClass().getResourceAsStream("/drawble/pausebutton.png")));
                }
            });
            mediaPlayer.setOnPaused(() -> {
                img_togleRun.setImage(new Image(getClass().getResourceAsStream("/drawble/playbutton.png")));
            });
            mediaPlayer.setOnReady(() -> {
                duration = mediaPlayer.getMedia().getDuration();
                updateValues();
            });
            spSoundViedo.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                if (spSoundViedo.isValueChanging()) {
                    mediaPlayer.setVolume(newValue.doubleValue() / 100.0);
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(PageCenterController.class.getName()).log(Level.SEVERE, null, ex);
        }
//</editor-fold>
    }
    
}
