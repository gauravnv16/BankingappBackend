package com.example.springapp;

public class SendFunds {
    String SENDER_ACCOUNT_NUMBER;
    String RECEIVER_ACCOUNT_NUMBER;
    Integer AMOUNT;

    public SendFunds(String SENDER_ACCOUNT_NUMBER, String RECEIVER_ACCOUNT_NUMBER, Integer AMOUNT) {
        this.SENDER_ACCOUNT_NUMBER = SENDER_ACCOUNT_NUMBER;
        this.RECEIVER_ACCOUNT_NUMBER = RECEIVER_ACCOUNT_NUMBER;
        this.AMOUNT = AMOUNT;
    }

    public String getSENDER_ACCOUNT_NUMBER() {
        return SENDER_ACCOUNT_NUMBER;
    }

    public String getRECEIVER_ACCOUNT_NUMBER() {
        return RECEIVER_ACCOUNT_NUMBER;
    }

    public Integer getAMOUNT() {
        return AMOUNT;
    }
}
