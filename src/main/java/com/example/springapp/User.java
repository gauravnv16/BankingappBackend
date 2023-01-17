package com.example.springapp;

public class User {
    Integer ID;
    String USERNAME;
    String PASSWORD;
    String EMAIL;
    Boolean ISADMIN;
    Boolean ISAPPROVED;

    public User(Integer ID, String USERNAME, String PASSWORD, String EMAIL, Boolean ISADMIN, Boolean ISAPPROVED) {
        this.ID = ID;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.EMAIL = EMAIL;
        this.ISADMIN = ISADMIN;
        this.ISAPPROVED = ISAPPROVED;
    }

    public Integer getID() {
        return ID;
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

    public Boolean getISADMIN() {
        return ISADMIN;
    }

    public Boolean getISAPPROVED() {
        return ISAPPROVED;
    }

    public String getUser(){
        return "{" +  "\"ID\" : \"" + ID + "\", " + "\"USERNAME\" : \"" + USERNAME + "\", " + "\"PASSWORD\" : \"" + PASSWORD + "\", " + "\"EMAIL\" : \"" + EMAIL + "\", " + "\"ISADMIN\" : \"" + ISADMIN + "\", " + "\"ISAPPROVED\" : \"" + ISAPPROVED + "\"},";
    } 



}
