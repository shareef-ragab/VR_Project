/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltion;

import java.sql.SQLException;
import com.wolf.javaFx.DateBase;

/**
 *
 * @author shareef_ragab
 */
public class VR_DataBase {

    public VR_DataBase() {
        //<editor-fold defaultstate="collapsed" desc="set date">
        Info_user.setNameTable("Info_user");
        Info_user.setCol_ID_user("ID_user");
        Info_user.setCol_address("address_user");
        Info_user.setCol_dateCreate("dateCreate");
        Info_user.setCol_email("email");
        Info_user.setCol_gender("gender");
        Info_user.setCol_numPhone("numPhone");
        Info_user.setCol_password("password");
        Info_user.setCol_state_log("state_log");
        Info_user.setCol_typeAccount("typeAccount");
        Info_user.setCol_username("username");
        Info_user.setCol_date_Barthe("date_Barthe");
        Trace_log.setNameTable("Trace_log");
        Trace_log.setDate_log_in("Date_log_in");
        Trace_log.setInfo_NIC("Info_NIC");
        Trace_log.setUser_name("User_name");
        Chat.setDateSend("DateSend");
        Chat.setID("ID");
        Chat.setID_DestChat("ID_DestChat");
        Chat.setID_DestUser("ID_DestUser");
        Chat.setID_Sender("ID_Sender");
        Chat.setID_SenderChat("ID_SenderChat");
        Chat.setID_chat("ID_chat");
        Chat.setNameTable("Chat");
        Chat.setReadChat("ReadChat");
        Chat.setTextSender("TextSender");
//</editor-fold>
    }

    public VR_DataBase(DateBase db) throws SQLException {
        this();
        //<editor-fold defaultstate="collapsed" desc="create table Info_user">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like '" + Info_user.getNameTable() + "';")) {
            db.setPst(db.getConn().prepareStatement("CREATE TABLE `info_user` (\n"
                    + Info_user.getCol_ID_user() + " int(11) NOT NULL AUTO_INCREMENT,\n"
                    + Info_user.getCol_username() + " varchar(45) CHARACTER  NOT NULL,\n"
                    + Info_user.getCol_password() + " varchar(45) CHARACTER  NOT NULL,\n"
                    + Info_user.getCol_email() + " varchar(45) CHARACTER  NOT NULL,\n"
                    + Info_user.getCol_numPhone() + " varchar(45) CHARACTER NOT NULL,\n"
                    + Info_user.getCol_typeAccount() + " varchar(45) CHARACTER  NOT NULL,\n"
                    + Info_user.getCol_date_Barthe() + " datetime NOT NULL,\n"
                    + Info_user.getCol_gender() + " varchar(45) CHARACTER NOT NULL,\n"
                    + Info_user.getCol_state_log() + " tinyint(1) NOT NULL DEFAULT '0',\n"
                    + Info_user.getCol_address() + " text NOT NULL,\n"
                    + Info_user.getCol_date_Barthe() + " varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (" + Info_user.getCol_ID_user() + "),\n"
                    + "  UNIQUE KEY `email_UNIQUE` (" + Info_user.getCol_email() + "),\n"
                    + "  UNIQUE KEY `num_phone_UNIQUE` (" + Info_user.getCol_numPhone() + "),\n"
                    + "  UNIQUE KEY `ID_USER_UNIQUE` (" + Info_user.getCol_ID_user() + ")\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=utf8;"));
            db.getPst().execute();
        }
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="create table listviedo">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like '" + listviedo.getNameTable() + "';")) {
            db.setPst(db.getConn().prepareStatement("CREATE TABLE " + listviedo.getNameTable() + " (\n"
                    + listviedo.getCol_ID() + " int(11) NOT NULL AUTO_INCREMENT,\n"
                    + listviedo.getCol_nameViedo() + " varchar(45) NOT NULL,\n"
                    + listviedo.getCol_pathDiscrption() + " text,\n"
                    + listviedo.getCol_pathViedo() + "   text NOT NULL,\n"
                    + listviedo.getCol_ID_Publish() + "  int(11) NOT NULL,\n"
                    + listviedo.getID_dateCreate() + "   datetime NOT NULL,\n"
                    + "  PRIMARY KEY (" + listviedo.getCol_ID() + "),\n"
                    + "  KEY `fk_Id_bublish_idx` (" + listviedo.getCol_ID_Publish() + "),\n"
                    + "  CONSTRAINT `fk_Id_bublish` FOREIGN KEY (" + listviedo.getCol_ID_Publish() + ") REFERENCES " + Info_user.getNameTable() + " (" + Info_user.getCol_ID_user() + ")\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT DEFAULT CHARSET=utf8 ;"));
            db.getPst().execute();
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="create table Trace_log">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like '" + Trace_log.getNameTable() + "';")) {
            db.setPst(db.getConn().prepareStatement("CREATE TABLE " + Trace_log.getNameTable() + " (\n"
                    + Trace_log.getUser_name() + " varchar(100) NOT NULL,\n"
                    + Trace_log.getPassword() + " varchar(100) NOT NULL,\n"
                    + Trace_log.getDate_log_in() + " varchar(45) NOT NULL,\n"
                    + Trace_log.getInfo_NIC() + " varchar(100) NOT NULL,\n"
                    + "  PRIMARY KEY (" + Trace_log.getUser_name() + ")\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;"));
            db.getPst().execute();
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="create table Chat">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like '" + Chat.getNameTable() + "';")) {
            db.setPst(db.getConn().prepareStatement("CREATE TABLE " + Chat.getNameTable() + " (\n"
                    + Chat.getID() + " int(11) NOT NULL AUTO_INCREMENT,\n"
                    + Chat.getID_chat() + " varchar(70) NOT NULL,\n"
                    + Chat.getID_Sender() + " varchar(45) NOT NULL,\n"
                    + Chat.getTextSender() + "  text,\n"
                    + Chat.getID_DestUser() + " varchar(45) NOT NULL,\n"
                    + Chat.getDateSend() + " datetime NOT NULL,\n"
                    + Chat.getReadChat() + "  tinyint(1) NOT NULL DEFAULT '0',\n"
                    + Chat.getID_DestChat() + " varchar(45) NOT NULL,\n"
                    + Chat.getID_SenderChat() + " varchar(45) NOT NULL,\n"
                    + "  PRIMARY KEY (" + Chat.getID() + "),\n"
                    + "  UNIQUE KEY `ID_UNIQUE` (" + Chat.getID() + " ),\n"
                    + "  KEY `Id_UserDest_idx` (" + Chat.getID_DestUser() + "),\n"
                    + "  KEY `id_UserSender_idx` (" + Chat.getID_Sender() + "),\n"
                    + "  KEY `Id_UserDest_Static_idx` (" + Chat.getID_DestChat() + "),\n"
                    + "  KEY `id_UserSenderChat_idx` (" + Chat.getID_SenderChat() + "),\n"
                    + "  CONSTRAINT `Id_UserDest` FOREIGN KEY (" + Chat.getID_DestUser() + ") REFERENCES " + Info_user.getNameTable() + " (" + Info_user.getCol_ID_user() + ") ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `Id_UserDest_chat` FOREIGN KEY (" + Chat.getID_DestChat() + ") REFERENCES " + Info_user.getNameTable() + "  (" + Info_user.getCol_ID_user() + ") ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `id_UserSender` FOREIGN KEY (" + Chat.getID_Sender() + ") REFERENCES " + Info_user.getNameTable() + "  (" + Info_user.getCol_ID_user() + ") ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                    + "  CONSTRAINT `id_UserSenderChat` FOREIGN KEY (" + Chat.getID_SenderChat() + ") REFERENCES " + Info_user.getNameTable() + "  (" + Info_user.getCol_ID_user() + ") ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;"));
            db.getPst().execute();
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="create View show_info">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like 'show_info';")) {
            db.setPst(db.getConn().prepareStatement("CREATE ALGORITHM=UNDEFINED DEFINER=`" + db.getUser() + "`@`" + db.getHostName() + "` SQL SECURITY DEFINER VIEW `show_info` AS"
                    + " select " + Info_user.getCol_ID_user() + " AS `ID_USER`"
                    + "," + Info_user.getCol_username() + " AS `user_name`"
                    + "," + Info_user.getCol_email() + " AS `email`"
                    + "," + Info_user.getCol_numPhone() + " AS `num_phone`"
                    + "," + Info_user.getCol_typeAccount() + " AS `type_Account`"
                    + "," + Info_user.getCol_gender() + " AS `gender`,"
                    + Info_user.getCol_date_Barthe() + " AS `dateBarth`,"
                    + "(YEAR(SYSDATE()) - YEAR(CAST(" + Info_user.getCol_date_Barthe() + " AS DATE))) AS `age` "
                    + "from " + Info_user.getNameTable() + ";"));
            db.getPst().execute();
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="create View show_info_log">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like 'show_info_log';")) {
            db.setPst(db.getConn().prepareStatement("CREATE ALGORITHM=UNDEFINED DEFINER=`" + db.getUser() + "`@`" + db.getHostName() + "` SQL SECURITY DEFINER VIEW `show_info_log` AS"
                    + " select " + Info_user.getCol_ID_user() + "  AS `ID_USER`,"
                    + Info_user.getCol_email() + " AS `email`,"
                    + Info_user.getCol_password() + " AS `password`,"
                    + Info_user.getCol_state_log() + " AS `state_log`"
                    + " from " + Info_user.getNameTable() + ";"));
            db.getPst().execute();
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="create View show_info_log">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like 'show_info_viedo';")) {
            db.setPst(db.getConn().prepareStatement("CREATE ALGORITHM=UNDEFINED DEFINER=`" + db.getUser() + "`@`" + db.getHostName() + "` SQL SECURITY DEFINER VIEW `show_info_viedo` AS"
                    + " select " + listviedo.getNameTable() + "." + listviedo.getCol_ID() + " AS `ID`,"
                    + listviedo.getNameTable() + "." + listviedo.getCol_nameViedo() + " AS `nameViedo`,"
                    + listviedo.getNameTable() + "." + listviedo.getCol_pathDiscrption() + " AS `DescreptionViedo`,"
                    + listviedo.getNameTable() + "." + listviedo.getCol_pathViedo() + " AS `pathViedo`,"
                    + Info_user.getNameTable() + "." + Info_user.getCol_username() + "  AS `user_name`,"
                    + Info_user.getNameTable() + "." + Info_user.getCol_email() + " AS `email`,"
                    + Info_user.getNameTable() + "." + Info_user.getCol_typeAccount() + " AS `type_Account`,"
                    + listviedo.getNameTable() + "." + listviedo.getID_dateCreate() + " AS `dateCreate` "
                    + " from (" + listviedo.getNameTable() + " join " + Info_user.getNameTable() + " on((" + listviedo.getNameTable() + "." + listviedo.getCol_ID_Publish() + "  = " + Info_user.getNameTable() + "." + Info_user.getCol_ID_user() + " )));"));
            db.getPst().execute();
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="create View view_chat">
        if (!db.setCuroser("show tables  from  " + db.getNameDataBase() + " like 'view_chat';")) {
            db.setPst(db.getConn().prepareStatement("CREATE ALGORITHM=UNDEFINED DEFINER=" + db.getUser() + "@" + db.getHostName() + " SQL SECURITY DEFINER VIEW `view_chat` AS "
                    + "select " + Chat.getNameTable() + "." + Chat.getID() + " AS `ID`"
                    + "," + Chat.getNameTable() + "." + Chat.getID_chat() + " AS `ID_chat`"
                    + "," + Chat.getNameTable() + "." + Chat.getID_Sender() + " AS `ID_Sender`"
                    + "," + Info_user.getNameTable() + "." + Info_user.getCol_username() + " AS `First_Name`"
                    + "," + Chat.getNameTable() + ". " + Chat.getTextSender() + " AS `textSender`"
                    + "," + Chat.getNameTable() + "." + Chat.getID_DestUser() + " AS `ID_DestUser`"
                    + "," + Chat.getNameTable() + "." + Chat.getDateSend() + " AS `DateSend`"
                    + "," + Chat.getNameTable() + "." + Chat.getReadChat() + " AS `readChat`"
                    + "," + Chat.getNameTable() + ". " + Chat.getID_DestChat() + " AS `ID_DestChat`"
                    + ",concat(`show_info`.`user_name`) AS `user_Name_dest`"
                    + ",`show_info`.`type_Account` AS `NAME_JOB_Dest`"
                    + "," + Chat.getNameTable() + "." + Chat.getID_SenderChat() + " AS `ID_SenderChat`"
                    + ",concat(`" + Info_user.getNameTable() + "`.`" + Info_user.getCol_username() + "`') AS `user_Name_sours`"
                    + "," + Info_user.getNameTable() + "." + Info_user.getCol_typeAccount() + " AS `NAME_JOB_sourse`"
                    + " from (((((((" + Info_user.getNameTable() + " join " + Chat.getNameTable() + " on((" + Info_user.getNameTable() + "." + Info_user.getCol_ID_user() + " = " + Chat.getNameTable() + "." + Chat.getID_Sender() + "))) "
                    + "join `show_info` on((`show_info`.`ID_USER` = " + Chat.getNameTable() + ". " + Chat.getID_DestChat() + "))));"));
            db.getPst().execute();
        }
        //</editor-fold>
    }

    public static class Chat {

        private static String nameTable, ID, ID_chat, ID_Sender, textSender, ID_DestUser, DateSend, readChat, ID_DestChat, ID_SenderChat;

        //<editor-fold defaultstate="collapsed" desc="set & get">
        /**
         * @return the nameTable
         */
        public static String getNameTable() {
            return nameTable;
        }

        /**
         * @param aNameTable the nameTable to set
         */
        public static void setNameTable(String aNameTable) {
            nameTable = aNameTable;
        }

        /**
         * @return the ID
         */
        public static String getID() {
            return ID;
        }

        /**
         * @param aID the ID to set
         */
        public static void setID(String aID) {
            ID = aID;
        }

        /**
         * @return the ID_chat
         */
        public static String getID_chat() {
            return ID_chat;
        }

        /**
         * @param aID_chat the ID_chat to set
         */
        public static void setID_chat(String aID_chat) {
            ID_chat = aID_chat;
        }

        /**
         * @return the ID_Sender
         */
        public static String getID_Sender() {
            return ID_Sender;
        }

        /**
         * @param aID_Sender the ID_Sender to set
         */
        public static void setID_Sender(String aID_Sender) {
            ID_Sender = aID_Sender;
        }

        /**
         * @return the textSender
         */
        public static String getTextSender() {
            return textSender;
        }

        /**
         * @param aTextSender the textSender to set
         */
        public static void setTextSender(String aTextSender) {
            textSender = aTextSender;
        }

        /**
         * @return the ID_DestUser
         */
        public static String getID_DestUser() {
            return ID_DestUser;
        }

        /**
         * @param aID_DestUser the ID_DestUser to set
         */
        public static void setID_DestUser(String aID_DestUser) {
            ID_DestUser = aID_DestUser;
        }

        /**
         * @return the DateSend
         */
        public static String getDateSend() {
            return DateSend;
        }

        /**
         * @param aDateSend the DateSend to set
         */
        public static void setDateSend(String aDateSend) {
            DateSend = aDateSend;
        }

        /**
         * @return the readChat
         */
        public static String getReadChat() {
            return readChat;
        }

        /**
         * @param aReadChat the readChat to set
         */
        public static void setReadChat(String aReadChat) {
            readChat = aReadChat;
        }

        /**
         * @return the ID_DestChat
         */
        public static String getID_DestChat() {
            return ID_DestChat;
        }

        /**
         * @param aID_DestChat the ID_DestChat to set
         */
        public static void setID_DestChat(String aID_DestChat) {
            ID_DestChat = aID_DestChat;
        }

        /**
         * @return the ID_SenderChat
         */
        public static String getID_SenderChat() {
            return ID_SenderChat;
        }

        /**
         * @param aID_SenderChat the ID_SenderChat to set
         */
        public static void setID_SenderChat(String aID_SenderChat) {
            ID_SenderChat = aID_SenderChat;
        }
//</editor-fold>

        private Chat() {
        }

    }

    public static class Trace_log {

        private static String nameTable, user_name, date_log_in, Info_NIC, password;

        //<editor-fold defaultstate="collapsed" desc="set & get">
        /**
         * @return the user_name
         */
        public static String getUser_name() {
            return user_name;
        }

        /**
         * @param aUser_name the user_name to set
         */
        public static void setUser_name(String aUser_name) {
            user_name = aUser_name;
        }

        /**
         * @return the date_log_in
         */
        public static String getDate_log_in() {
            return date_log_in;
        }

        /**
         * @param aDate_log_in the date_log_in to set
         */
        public static void setDate_log_in(String aDate_log_in) {
            date_log_in = aDate_log_in;
        }

        /**
         * @return the nameTable
         */
        public static String getNameTable() {
            return nameTable;
        }

        /**
         * @param aNameTable the nameTable to set
         */
        public static void setNameTable(String aNameTable) {
            nameTable = aNameTable;
        }
        //</editor-fold>

        public static String getInfo_NIC() {
            return Info_NIC;
        }

        public static void setInfo_NIC(String aInfo_NIC) {
            Info_NIC = aInfo_NIC;
        }

        public static String getPassword() {
            return password;
        }

        public static void setPassword(String aPassword) {
            password = aPassword;
        }

        private Trace_log() {
        }
    }

    public static class Info_user {

        private static String nameTable, col_ID_user, col_username, col_password, col_email, col_address, col_numPhone, col_typeAccount, col_dateCreate, col_gender, col_state_log, col_date_Barthe;

        public static String getCol_date_Barthe() {
            return col_date_Barthe;
        }

        public static void setCol_date_Barthe(String col_date_Barthe) {
            Info_user.col_date_Barthe = col_date_Barthe;
        }

        public static String getNameTable() {
            return nameTable;
        }

        public static void setNameTable(String aNameTable) {
            nameTable = aNameTable;
        }

        public static String getCol_ID_user() {
            return col_ID_user;
        }

        public static void setCol_ID_user(String aCol_ID_user) {
            col_ID_user = aCol_ID_user;
        }

        public static String getCol_username() {
            return col_username;
        }

        public static void setCol_username(String aCol_username) {
            col_username = aCol_username;
        }

        public static String getCol_password() {
            return col_password;
        }

        public static void setCol_password(String aCol_password) {
            col_password = aCol_password;
        }

        public static String getCol_email() {
            return col_email;
        }

        public static void setCol_email(String aCol_email) {
            col_email = aCol_email;
        }

        public static String getCol_address() {
            return col_address;
        }

        public static void setCol_address(String aCol_address) {
            col_address = aCol_address;
        }

        public static String getCol_numPhone() {
            return col_numPhone;
        }

        public static void setCol_numPhone(String aCol_numPhone) {
            col_numPhone = aCol_numPhone;
        }

        public static String getCol_typeAccount() {
            return col_typeAccount;
        }

        public static void setCol_typeAccount(String aCol_typeAccount) {
            col_typeAccount = aCol_typeAccount;
        }

        public static String getCol_dateCreate() {
            return col_dateCreate;
        }

        public static void setCol_dateCreate(String aCol_dateCreate) {
            col_dateCreate = aCol_dateCreate;
        }

        public static String getCol_gender() {
            return col_gender;
        }

        public static void setCol_gender(String aCol_gender) {
            col_gender = aCol_gender;
        }

        public static String getCol_state_log() {
            return col_state_log;
        }

        public static void setCol_state_log(String aCol_state_log) {
            col_state_log = aCol_state_log;
        }
    }

    public static class listviedo {

        private static String nameTable, col_ID, col_nameViedo, col_pathDiscrption, col_pathViedo, col_ID_Publish, ID_dateCreate;

        /**
         * @return the nameTable
         */
        public static String getNameTable() {
            return nameTable;
        }

        /**
         * @param aNameTable the nameTable to set
         */
        public static void setNameTable(String aNameTable) {
            nameTable = aNameTable;
        }

        /**
         * @return the col_ID
         */
        public static String getCol_ID() {
            return col_ID;
        }

        /**
         * @param aCol_ID the col_ID to set
         */
        public static void setCol_ID(String aCol_ID) {
            col_ID = aCol_ID;
        }

        /**
         * @return the col_nameViedo
         */
        public static String getCol_nameViedo() {
            return col_nameViedo;
        }

        /**
         * @param aCol_nameViedo the col_nameViedo to set
         */
        public static void setCol_nameViedo(String aCol_nameViedo) {
            col_nameViedo = aCol_nameViedo;
        }

        /**
         * @return the col_pathDiscrption
         */
        public static String getCol_pathDiscrption() {
            return col_pathDiscrption;
        }

        /**
         * @param aCol_pathDiscrption the col_pathDiscrption to set
         */
        public static void setCol_pathDiscrption(String aCol_pathDiscrption) {
            col_pathDiscrption = aCol_pathDiscrption;
        }

        /**
         * @return the col_ID_Publish
         */
        public static String getCol_ID_Publish() {
            return col_ID_Publish;
        }

        /**
         * @param aCol_ID_Publish the col_ID_Publish to set
         */
        public static void setCol_ID_Publish(String aCol_ID_Publish) {
            col_ID_Publish = aCol_ID_Publish;
        }

        /**
         * @return the ID_dateCreate
         */
        public static String getID_dateCreate() {
            return ID_dateCreate;
        }

        /**
         * @param aID_dateCreate the ID_dateCreate to set
         */
        public static void setID_dateCreate(String aID_dateCreate) {
            ID_dateCreate = aID_dateCreate;
        }

        /**
         * @return the col_pathViedo
         */
        public static String getCol_pathViedo() {
            return col_pathViedo;
        }

        /**
         * @param aCol_pathViedo the col_pathViedo to set
         */
        public static void setCol_pathViedo(String aCol_pathViedo) {
            col_pathViedo = aCol_pathViedo;
        }
    }
}
