/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plagin;

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
//import net.glxn.qrgen.QRCode;
//import net.glxn.qrgen.image.ImageType;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 *
 * @author shareef_ragab
 */
public class Tools {

    private InputStream input;
    private File file;
    private PrintWriter brintFile = null;
    private LocalDateTime DataTime;
    private NetworkInterface networkInterface;
    private String nameSystem;
    private boolean enableReg = true;

    public Tools() {

    }

    public Tools(String nameSystem) throws IOException {
        setNameSystem(nameSystem);
        path(nameSystem, "tools");
    }

    public Tools(String nameSystem, DateBase db) throws SQLException, IOException {
        this(nameSystem);
        //<editor-fold defaultstate="collapsed" desc="create Table trace_error_program">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like 'trace_error_program';")) {
            db.setPst(db.getConn().prepareStatement("CREATE TABLE `trace_error_program` (\n"
                    + "  `ID` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `DataException` date NOT NULL,\n"
                    + "  `TimeException` time NOT NULL,\n"
                    + "  `nameException` varchar(80) NOT NULL,\n"
                    + "  `MassegaException` varchar(80) NOT NULL,\n"
                    + "  `codeException` varchar(45) NOT NULL,\n"
                    + "  `informationException` text NOT NULL,\n"
                    + "  PRIMARY KEY (`ID`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;"));
            db.getPst().execute();
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="create Table trace_activate_user">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like 'trace_activate_user';")) {
            db.setPst(db.getConn().prepareStatement("CREATE TABLE `trace_activate_user` (\n"
                    + "  `ID` int(11) NOT NULL  AUTO_INCREMENT,\n"
                    + "  `ID_User` varchar(45) NOT NULL DEFAULT 'Haker',\n"
                    + "  `activate` varchar(500) NOT NULL,\n"
                    + "  `timeActivte` time NOT NULL,\n"
                    + "  `dateActivte` date NOT NULL,\n"
                    + "  PRIMARY KEY (`ID`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;"));
            db.getPst().execute();
        }
//</editor-fold>
    }

    private String path(String nameProgramm, String namePart) throws IOException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        File temp = File.createTempFile(nameProgramm, ".tmp");
        setFile(new File(temp.getParent() + "\\" + nameProgramm + "\\" + namePart + "\\temp\\APP"));
        if (!getFile().exists()) {
            getFile().mkdirs();
        }
        temp.delete();
        return temp.getParent() + "\\" + nameProgramm + "\\" + namePart + "\\temp\\APP";
//</editor-fold>
    }

    private void QRcode(String myString, String path) throws FileNotFoundException, IOException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        /*ByteArrayOutputStream QR = QRCode.from(myString).to(ImageType.PNG).stream();
        setFile(new File(path));
        FileOutputStream fileOut = new FileOutputStream(getFile());
        fileOut.write(QR.toByteArray());
        fileOut.flush();*/
//</editor-fold>
    }

    private void barcode(String myString, String path) throws IOException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        Code128Bean code128 = new Code128Bean();
        code128.setHeight(10f);
        code128.setModuleWidth(0.3);
        code128.setQuietZone(20);
        code128.doQuietZone(true);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        code128.generateBarcode(canvas, myString);
        canvas.finish();
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(baos.toByteArray());
        fos.flush();
//</editor-fold>

    }

    private void select(RadioButton tere1, RadioButton tere2, PreparedStatement pst, int parameterIndex) throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        if (tere1.isSelected()) {
            pst.setString(parameterIndex, tere1.getText());
        } else if (tere2.isSelected()) {
            pst.setString(parameterIndex, tere2.getText());
        } else {
            throw new SQLException("No Select");
        }

//</editor-fold>
    }

    private void select(RadioButton tere1, RadioButton tere2, ResultSet rs, String parameterIndex, String tere1True, String tere2True) throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        if (rs.getString(parameterIndex).equals(tere1True)) {
            tere1.setSelected(true);
        } else if (rs.getString(parameterIndex).equals(tere2True)) {
            tere2.setSelected(true);
        }

//</editor-fold>
    }

    private Image image(Window part, FileChooser chooserImage, ImageView label) throws IllegalArgumentException, HeadlessException, IOException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        chooser(part, chooserImage, "ImgeFile", "select image", "*.jpg", "*.png");
        if (getFile() != null && getFile().length() < 56637) {
            return new Image(getFile().toURI().toString(), label.getFitWidth(), label.getFitHeight(), true, true);
        } else {
            setFile(null);
            return null;
        }
//</editor-fold>
    }

    private boolean comparative(TextField in1, TextField in2, Label out, String massegeFalse, String massegeTrue) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        if (!in1.getText().isEmpty() && !in2.getText().isEmpty()) {
            if (!in1.getText().equals(in2.getText())) {
                out.setText(massegeFalse);
                return false;
            } else {
                out.setText(massegeTrue);
                return true;
            }
        }
        return false;
//</editor-fold>
    }

    private boolean comparative(String in1, String in2, Label out, String massegeFalse, String massegeTrue) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        if (!in1.isEmpty() && !in2.isEmpty()) {
            if (!in1.equals(in2)) {
                out.setText(massegeFalse);
                return false;
            } else {
                out.setText(massegeTrue);
                return true;
            }
        }
        return false;
//</editor-fold>
    }

    private void reCombo(ComboBox<String> combo, String[] coColList) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        combo.setItems(null);
        ObservableList<String> Item;
        Item = FXCollections.observableArrayList();
        for (String item : coColList) {
            Item.add(item);
        }
        combo.setItems(Item);
//</editor-fold>
    }

    private void chooser(Window parent, FileChooser chooser, String description, String title, String... extensions) throws FileNotFoundException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(description, extensions);
        chooser.getExtensionFilters().addAll(filter);
        chooser.setTitle(title);
        setFile(chooser.showOpenDialog(parent));
        setInput(new FileInputStream(getFile()));
//</editor-fold>
    }

    private String isData(LocalDate DataClender) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        int year = DataClender.getYear();
        int month = DataClender.getMonthValue();
        int day = DataClender.getDayOfMonth();
        return year + "-" + month + "-" + day;
//</editor-fold>
    }

    private LocalDate isData(String DataClender) {
        //<editor-fold defaultstate="collapsed" desc="statment">

        int year = Integer.parseInt(DataClender.substring(0, 4));
        int month = Integer.parseInt(DataClender.substring(5, 7));
        int day = Integer.parseInt(DataClender.substring(8, 10));
        return LocalDate.of(year, month, day);
//</editor-fold>
    }

    private String Time() {
        //<editor-fold defaultstate="collapsed" desc="statment">
        setDataTime(LocalDateTime.now());
        int hour = getDataTime().getHour();
        if (getDataTime().getHour() > 12) {
            hour = getDataTime().getHour() - 12;
        }
        int minute = getDataTime().getMinute();
        int sec = getDataTime().getSecond();
        String zeroMen = "";
        String zerosec = "";
        String zerominte = "";
        if (hour < 10) {
            zeroMen = "0";
        }
        if (minute < 10) {
            zerominte = "0";
        }
        if (sec < 10) {
            zerosec = "0";
        }
        return zeroMen + hour + ":" + zerominte + minute + ":" + zerosec + sec;
//</editor-fold>
    }

    private String Date() {
        //<editor-fold defaultstate="collapsed" desc="statment">
        setDataTime(LocalDateTime.now());
        int month = getDataTime().getMonthValue();
        int day = getDataTime().getDayOfMonth();
        String zeromonth = "";
        String zeroday = "";
        if (month < 10) {
            zeromonth = "0";
        }
        if (day < 10) {
            zeroday = "0";
        }
        return getDataTime().getYear() + "-" + zeromonth + month + "-" + zeroday + day;
//</editor-fold>
    }

    private ButtonType showMaseg(Alert.AlertType alertType, String contentText, String headerText, String title, ButtonType... buttons) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        Alert Message = new Alert(alertType, contentText, buttons);
        Message.setHeaderText(headerText);
        Message.setTitle(title);
        Message.showAndWait();
        return Message.getResult();
//</editor-fold>
    }

    private void rgsterActivate(String ActvteMssege, String ID_user, String nameUser, DateBase db, TextArea statErrore, boolean ShowMass) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        try {
            setFile(new File(getPath(getNameSystem(), "tools") + "\\Activtie\\trace"));
            if (!getFile().exists()) {
                getFile().mkdirs();
                getFile().createNewFile();
            }
            setDataTime(LocalDateTime.now());
            setFile(new File(getPath(getNameSystem(), "tools") + "\\regster" + getDate() + ".txt"));
            setBrintFile(new PrintWriter(new FileWriter(getFile(), true)));
            getBrintFile().print(" \n *******************************************************************************\n *"
                    + "\n * Data Activate  : " + getDate() + "\n *"
                    + "\n * TimeActivate  : " + getTime() + "\n *"
                    + "\n * ID_user : " + ID_user + " \n *"
                    + "\n * Activate : " + ActvteMssege + " \n *"
                    + "\n * name user : " + nameUser + " \n *"
                    + "\n *************************************************************************************\n ");
            if (ShowMass) {
                showMasseg(Alert.AlertType.INFORMATION, ActvteMssege, "Information", "Massage");
            }
            if (enableReg) {
                if (db != null) {
                    db.setCuroser("SELECT * FROM trace_activate_user;");
                    db.getRs().moveToInsertRow();
                    db.getRs().updateString("dateActivte", getDate());
                    db.getRs().updateString("timeActivte", getTime());
                    db.getRs().updateString("ID_User", ID_user);
                    db.getRs().updateString("activate", ActvteMssege);
                    db.getRs().insertRow();
                }

                if (statErrore != null) {
                    statErrore.setText(statErrore.getText() + "\n----------------\n" + ActvteMssege + "\n--------------\n");
                    statErrore.end();
                }
            }
        } catch (SQLException | IOException ex1) {
            MadicException(ex1, "1x000001005", Logger.getGlobal(), db, statErrore, false);
        } finally {
            getBrintFile().close();
        }
//</editor-fold>
    }

    private void rgsterError(Exception ex, String code, Logger log, DateBase db, TextArea statreg, boolean ShowMass) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        try {
            log.log(Level.SEVERE, ex.getMessage(), ex);
            setFile(new File(getFile().getPath() + "\\Activtie\\Error"));
            if (!getFile().exists()) {
                getFile().mkdirs();
            }
            setDataTime(LocalDateTime.now());
            setFile(new File(getFile().getPath() + "\\regster " + getDate() + ".txt"));
            setBrintFile(new PrintWriter(new FileWriter(getFile(), true)));
            getBrintFile().print(" \n *******************************************************************************\n *"
                    + "\n * Data Exception or error : " + getDate() + "\n *"
                    + "\n * Time Exception or error : " + getTime() + "\n *"
                    + "\n * Massege Exception or error : " + ex.getMessage() + "\n *"
                    + "\n * local Exception or error : " + ex.getLocalizedMessage() + "\n *"
                    + "\n * informtion Exception or error : " + ex.fillInStackTrace() + "\n *"
                    + "\n * code Exception or error : " + code + "\n *"
                    + "\n *************************************************************************************\n ");
            ex.printStackTrace(getBrintFile());

            if (ShowMass) {
                showMasseg(Alert.AlertType.ERROR, ex.getMessage() + "\t " + code, "Informatiom", "Error Massage");
            }
            if (enableReg) {
                if (db != null) {
                    db.setCuroser("SELECT * FROM trace_error_program;");
                    db.getRs().moveToInsertRow();
                    db.getRs().updateString("DataException", getDate());
                    db.getRs().updateString("TimeException", getTime());
                    db.getRs().updateString("nameException", ex.toString());
                    db.getRs().updateString("MassegaException", ex.getMessage());
                    db.getRs().updateString("codeException", code);
                    db.getRs().updateString("informationException", ex.fillInStackTrace().toString());
                    db.getRs().insertRow();
                }
                if (statreg != null) {
                    statreg.setText(statreg.getText() + "\n----------------\n" + ex.getMessage() + "\n--------------\n");
                    statreg.end();
                }
            }
        } catch (SQLException | IOException ex1) {
            ex1.fillInStackTrace();
        } finally {
            getBrintFile().close();
        }
//</editor-fold>
    }

    private void spenner(Spinner<Integer> spen, int min, int max, int start) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        SpinnerValueFactory<Integer> value = new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, start);
        spen.setValueFactory(value);

//</editor-fold>
    }

    private Label List(String textAbove, Node graphicAbove, String id, NodeOrientation value, Pos valuepos) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        Label labelAbove = new Label(textAbove, graphicAbove);
        labelAbove.setId(id);
        labelAbove.setNodeOrientation(value);
        labelAbove.setAlignment(valuepos);
        return labelAbove;
//</editor-fold>
    }

    private void ZipAdd(String path, File file) throws IOException, FileNotFoundException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        byte[] buf = new byte[1024];
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                int len;
                while ((len = fileInputStream.read(buf)) > 0) {
                    zipOutputStream.write(buf, 0, len);
                }
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
        }
//</editor-fold>
    }

    private String Symbole(boolean chech, String out) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        String symbole = "-";
        if (chech) {
            symbole = out;
        }
        return symbole;
//</editor-fold>
    }

    private void sender(ArrayList<String> From, ArrayList<String> to) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        for (int i = 0; i < From.size(); i++) {
            to.add(From.get(i));
        }
//</editor-fold>
    }

    private void lockZip(InputStream input, String Path) throws IOException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        try (ZipInputStream zis = new ZipInputStream(input)) {
            byte[] buffer = new byte[4096];
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                FileOutputStream fos = null;
                fos = new FileOutputStream(Path + "\\" + ze.getName());
                int numBytes;
                while ((numBytes = zis.read(buffer, 0, buffer.length)) != -1) {
                    fos.write(buffer, 0, numBytes);
                }
                fos.close();
                zis.closeEntry();
                setFile(new File(Path + "\\" + ze.getName()));
                setInput(new FileInputStream(getFile()));
            }
        }
//</editor-fold>
    }

    private String MacAddress(byte[] macadd) {
        //<editor-fold defaultstate="collapsed" desc="statment">
        String value = "";
        for (int j = 0; j < macadd.length; j++) {
            String item = "";
            byte var = macadd[j];
            String old = Integer.toHexString(var);
            item = old.replaceAll("ffffff", "");
            if (item.length() == 1) {
                item = "0" + item;
            }
            value += item + "-";
        }
        return value.substring(0, 17).toUpperCase();
//</editor-fold>
    }

    private String infoNetworkInterface(NetworkInterface face) throws SocketException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        String info = "";
        info = "Index :" + face.getIndex() + " ,\n";
        info += "DisplayName :" + face.getDisplayName() + " ,\n";
        if (face.getHardwareAddress() != null) {
            info += "MAC Address :" + MacAddress(face.getHardwareAddress()) + " ,\n";
        }
        info += "InterfaceAddresses :" + face.getInterfaceAddresses() + " ,\n";
        info += "Name :" + face.getName() + " ,\n";
        Enumeration<InetAddress> intre = face.getInetAddresses();
        while (intre.hasMoreElements()) {
            InetAddress fa = intre.nextElement();
            info += "Address :" + Arrays.toString(fa.getAddress()) + ",\n";
            info += "CanonicalHostName :" + fa.getCanonicalHostName() + ", \n";
            info += "HostAddress :" + fa.getHostAddress() + ", \n";
            info += "HostName :" + fa.getHostName() + ", \n";
        }
        return info;
//</editor-fold>
    }

    private boolean copy(String pathFrom, String pathTo) throws FileNotFoundException, IOException {
        //<editor-fold defaultstate="collapsed" desc="statment">
        byte[] buf = new byte[1024];
        File file = new File(pathFrom);
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(pathTo);
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        out.flush();
        out.close();
        return true; 
//</editor-fold>
    }

    /**
     *
     * @param face
     * @return
     * @throws SocketException
     */
    public String getInfoNetworkInterface(NetworkInterface face) throws SocketException {
        return infoNetworkInterface(face);
    }

    /**
     *
     * @param chech
     * @param out
     * @return
     */
    public String getSymblo(boolean chech, String out) {
        return Symbole(chech, out);
    }

    /**
     *
     * @param nameProgramm
     * @param namePart
     * @return
     * @throws IOException
     */
    public String getPath(String nameProgramm, String namePart) throws IOException {
        return path(nameProgramm, namePart);
    }

    /**
     *
     * @param input
     * @param Path
     * @throws IOException
     */
    public void openZip(InputStream input, String Path) throws IOException {
        lockZip(input, Path);
    }

    /**
     *
     * @param From
     * @param to
     */
    public void copyArreyList(ArrayList<String> From, ArrayList<String> to) {
        sender(From, to);
    }

    /**
     *
     * @param tere1
     * @param tere2
     * @param rs
     * @param parameterIndex
     * @param tere1True
     * @param tere2True
     * @throws SQLException
     */
    public void setSelect(RadioButton tere1, RadioButton tere2, ResultSet rs, String parameterIndex, String tere1True, String tere2True) throws SQLException {
        select(tere1, tere2, rs, parameterIndex, tere1True, tere2True);
    }

    /**
     *
     * @param path
     * @param file
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void createZipAdd(String path, File file) throws IOException, FileNotFoundException {
        ZipAdd(path, file);
    }

    /**
     *
     * @param myString
     * @param path
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void creatQRcode(String myString, String path) throws FileNotFoundException, IOException {
        QRcode(myString, path);
    }

    /**
     *
     * @param myString
     * @param path
     * @throws IOException
     */
    public void creatBarcode(String myString, String path) throws IOException {
        barcode(myString, path);
    }

    /**
     *
     * @param textAbove
     * @param graphicAbove
     * @param valuepos
     * @param id
     * @param value
     * @return
     */
    public Label setList(String textAbove, Node graphicAbove, String id, NodeOrientation value, Pos valuepos) {
        return List(textAbove, graphicAbove, id, value, valuepos);
    }

    /**
     *
     * @param alertType
     * @param contentText
     * @param headerText
     * @param title
     * @param buttons
     * @return
     */
    public ButtonType showMasseg(Alert.AlertType alertType, String contentText, String headerText, String title, ButtonType... buttons) {
        return showMaseg(alertType, contentText, headerText, title, buttons);
    }

    /**
     *
     * @param spen
     * @param min
     * @param max
     * @param start
     */
    public void setSpanner(Spinner<Integer> spen, int min, int max, int start) {
        spenner(spen, min, max, start);
    }

    /**
     *
     * @param ActvteMssege
     * @param ID_user
     * @param nameUser
     * @param db
     * @param statreg
     * @param ShowMass
     */
    public void trace(String ActvteMssege, String ID_user, String nameUser, DateBase db, TextArea statreg, boolean ShowMass) {
        rgsterActivate(ActvteMssege, ID_user, nameUser, db, statreg, ShowMass);
    }

    /**
     *
     * @return
     */
    public String getTime() {
        return Time();
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return Date();
    }

    /**
     *
     * @param ex
     * @param code
     * @param log
     * @param db
     * @param statreg
     * @param ShowMass
     */
    public void MadicException(Exception ex, String code, Logger log, DateBase db, TextArea statreg, boolean ShowMass) {
        rgsterError(ex, code, log, db, statreg, ShowMass);
    }

    /**
     *
     * @param tere1
     * @param tere2
     * @param pst
     * @param parameterIndex
     * @param tere1True
     * @param tere2True
     * @throws SQLException
     */
    public void getSelect(RadioButton tere1, RadioButton tere2, PreparedStatement pst, int parameterIndex) throws SQLException {
        select(tere1, tere2, pst, parameterIndex);
    }

    /**
     *
     * @param part
     * @param chooserImage
     * @param label
     * @return
     * @throws java.io.IOException
     */
    public Image getimage(Window part, FileChooser chooserImage, ImageView label) throws IllegalArgumentException, HeadlessException, IOException {
        return image(part, chooserImage, label);
    }

    /**
     *
     * @param in1
     * @param in2
     * @param out
     * @param massegeFalse
     * @param massegeTrue
     * @return
     */
    public boolean getComparative(TextField in1, TextField in2, Label out, String massegeFalse, String massegeTrue) {
        return comparative(in1, in2, out, massegeFalse, massegeTrue);
    }

    /**
     *
     * @param in1
     * @param in2
     * @param out
     * @param massegeFalse
     * @param massegeTrue
     * @return
     */
    public boolean getComparative(String in1, String in2, Label out, String massegeFalse, String massegeTrue) {
        return comparative(in1, in2, out, massegeFalse, massegeTrue);
    }

    /**
     *
     * @param parent
     * @param chooserImage
     * @param description
     * @param title
     * @param extensions
     * @throws java.io.FileNotFoundException
     */
    public void setFile(Window parent, FileChooser chooserImage, String description, String title, String... extensions) throws FileNotFoundException {
        chooser(parent, chooserImage, description, title, extensions);
    }

    public boolean copyFile(String pathFrom, String pathTo) throws FileNotFoundException, IOException {
        return copy(pathFrom, pathTo);
    }

    //<editor-fold defaultstate="collapsed" desc="set & get">
    /**
     * @return the input
     */
    public InputStream getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(InputStream input) {
        this.input = input;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the brintFile
     */
    public PrintWriter getBrintFile() {
        return brintFile;
    }

    /**
     * @param brintFile the brintFile to set
     */
    public void setBrintFile(PrintWriter brintFile) {
        this.brintFile = brintFile;
    }

    /**
     * @return the DataTime
     */
    public LocalDateTime getDataTime() {
        return DataTime;
    }

    /**
     * @param DataTime the DataTime to set
     */
    public void setDataTime(LocalDateTime DataTime) {
        this.DataTime = DataTime;
    }

    /**
     * @return the networkInterface
     */
    public NetworkInterface getNetworkInterface() {
        return networkInterface;
    }

    /**
     * @param networkInterface the networkInterface to set
     */
    public void setNetworkInterface(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }

    /**
     * @return the enableReg
     */
    public boolean isEnableReg() {
        return enableReg;
    }

    /**
     * @return the nameSystem
     */
    public String getNameSystem() {
        return nameSystem;
    }

    /**
     * @param nameSystem the nameSystem to set
     */
    public void setNameSystem(String nameSystem) {
        this.nameSystem = nameSystem;
    }
//</editor-fold>
}
