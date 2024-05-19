package com.example.realtimedb;

public class UserDM {

    String userName,userEmail,eserPhone,userDesc;

    public UserDM(){

    }

    public UserDM(String userName, String userEmail, String eserPhone, String userDesc) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.eserPhone = eserPhone;
        this.userDesc = userDesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEserPhone() {
        return eserPhone;
    }

    public void setEserPhone(String eserPhone) {
        this.eserPhone = eserPhone;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
}
