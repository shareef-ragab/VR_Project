/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeltion;

/**
 *
 * @author shareef_ragab
 */
public class Trace_log {

    private String info_NIC, date_log, password, user_name, ID_user, ID;

    public Trace_log(String info_NIC, String password, String user_name, String ID_user) {
        this.info_NIC = info_NIC;
        this.password = password;
        this.user_name = user_name;
        this.ID_user = ID_user;
    }

    public String getInfo_NIC() {
        return info_NIC;
    }

    public void setInfo_NIC(String info_NIC) {
        this.info_NIC = info_NIC;
    }

    public String getDate_log() {
        return date_log;
    }

    public void setDate_log(String date_log) {
        this.date_log = date_log;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getID_user() {
        return ID_user;
    }

    public void setID_user(String ID_user) {
        this.ID_user = ID_user;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
