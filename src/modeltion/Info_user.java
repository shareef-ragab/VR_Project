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
public class Info_user {

    private String ID_USER, user_name, password, num_phone, type_Account, gender, state_log;

    public Info_user(String user_name, String password, String num_phone, String type_Account, String gender) {
        this.user_name = user_name;
        this.password = password;
        this.num_phone = num_phone;
        this.type_Account = type_Account;
        this.gender = gender;
    }

    public String getID_USER() {
        return ID_USER;
    }

    public void setID_USER(String ID_USER) {
        this.ID_USER = ID_USER;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNum_phone() {
        return num_phone;
    }

    public void setNum_phone(String num_phone) {
        this.num_phone = num_phone;
    }

    public String getType_Account() {
        return type_Account;
    }

    public void setType_Account(String type_Account) {
        this.type_Account = type_Account;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState_log() {
        return state_log;
    }

    public void setState_log(String state_log) {
        this.state_log = state_log;
    }
}
