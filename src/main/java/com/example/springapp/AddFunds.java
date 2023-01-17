package com.example.springapp;

public class AddFunds {
    String ACCOUNT_NUMBER;
    Integer AMOUNT;

    public AddFunds(String ACCOUNT_NUMBER, Integer AMOUNT) {
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.AMOUNT = AMOUNT;
    }

    public String getACCOUNT_NUMBER() {
        return ACCOUNT_NUMBER;
    }

    public Integer getAMOUNT() {
        return AMOUNT;
    }

    
}
