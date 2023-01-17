package com.example.springapp;

public class UserDetails {
    String ID;
    String USERNAME;
    String EMAIL;
    Boolean ISAPPROVED;
    String ACCOUNT_NUMBER;
    Integer BALANCE;
    Integer ACCOUNT_ID;

    public UserDetails(String ID, String USERNAME, String EMAIL, Boolean ISAPPROVED, String ACCOUNT_NUMBER, Integer BALANCE, Integer ACCOUNT_ID) {
        this.ID = ID;
        this.USERNAME = USERNAME;
        this.EMAIL = EMAIL;
        this.ISAPPROVED = ISAPPROVED;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.BALANCE = BALANCE;
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    public String getID() {
        return ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public Boolean getISAPPROVED() {
        return ISAPPROVED;
    }

    public String getACCOUNT_NUMBER() {
        return ACCOUNT_NUMBER;
    }

    public Integer getBALANCE() {
        return BALANCE;
    }

    public Integer getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public String getUser(){
        return "{" +  "\"ID\" : \"" + ID + "\", " + "\"USERNAME\" : \"" + USERNAME + "\", " + "\"EMAIL\" : \"" + EMAIL + "\", " + "\"ISAPPROVED\" : \"" + ISAPPROVED + "\", " + "\"ACCOUNT_NUMBER\" : \"" + ACCOUNT_NUMBER + "\", " + "\"BALANCE\" : \"" + BALANCE + "\", " + "\"ACCOUNT_ID\" : \"" + ACCOUNT_ID + "\"},";
    }
}
