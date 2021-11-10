package com.example.sysfood;

public class UserHelper {

        String fullName, email,password, phone_no, userName;

    public UserHelper() {

    }

    public UserHelper(String fullName, String email, String password, String phone_no, String userName) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone_no = phone_no;
        this.userName = userName;
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
