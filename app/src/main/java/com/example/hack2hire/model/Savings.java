package com.example.hack2hire.model;

public class Savings {

    private int id;

    private int customerId;

    private long amount;

    private int transationId;

    private String date;

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setTransationId(int transationId) {
        this.transationId = transationId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public long getAmount() {
        return amount;
    }

    public int getTransationId() {
        return transationId;
    }

    public String getDate() {
        return date;
    }
}
