package com.example.springapp;

public class Transaction {
    Integer ID;
    String ACCOUNT_NUMBER;
    Integer AMOUNT;
    String TRANSFERED_ACCOUNT_NUMBER;
    String TRANSACTION_TYPE;
    String TRANSACTION_DATE;
    String DESCRIPTION;

    public Transaction(Integer ID, String ACCOUNT_NUMBER, Integer
AMOUNT, String TRANSFERED_ACCOUNT_NUMBER, String TRANSACTION_TYPE, 
String TRANSACTION_DATE, String
DESCRIPTION) {
        this.ID = ID;
        this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
        this.AMOUNT = AMOUNT;
        this.TRANSFERED_ACCOUNT_NUMBER = TRANSFERED_ACCOUNT_NUMBER;
        this.TRANSACTION_TYPE = TRANSACTION_TYPE;
        this.TRANSACTION_DATE = TRANSACTION_DATE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getTransaction() {
        return "{\"ID\":" + ID + ",\"ACCOUNT_NUMBER\":\"" + ACCOUNT_NUMBER +
"\",\"AMOUNT\":" + AMOUNT + ",\"TRANSFERED_ACCOUNT_NUMBER\":\"" +
TRANSFERED_ACCOUNT_NUMBER + "\",\"TRANSACTION_TYPE\":\"" + TRANSACTION_TYPE +
"\",\"DESCRIPTION\":\"" + DESCRIPTION + "\"},";
    }

    public Integer getID() {
        return ID;
    }

    public String getACCOUNT_NUMBER() {
        return ACCOUNT_NUMBER;
    }

    public Integer getAMOUNT() {
        return AMOUNT;
    }

    public String getTRANSFERED_ACCOUNT_NUMBER() {
        return TRANSFERED_ACCOUNT_NUMBER;
    }

    public String getTRANSACTION_TYPE() {
        return TRANSACTION_TYPE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getTRANSACTION_DATE() {
        return TRANSACTION_DATE;
    }


}
