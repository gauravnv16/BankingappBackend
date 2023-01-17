package com.example.springapp;

public class RegisterUser {

    String ACCOUNT_NUMBER;
    String USERNAME;
    String PASSWORD;
    String EMAIL;

    public RegisterUser(String USERNAME, String PASSWORD, String EMAIL, String ACCOUNT_NUMBER) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.EMAIL = EMAIL;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getACCOUNT_NUMBER() {
        return ACCOUNT_NUMBER;
    }
}
