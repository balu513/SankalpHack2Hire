package com.example.hack2hire.model;

import java.util.Date;

public class Transaction {

    private int id;

    private long amount;

    private String  name;

    private int customerId;

    private int itemId;



    private Date date;

    public Transaction(int id, long amount, String name, int customerId, int itemId, Date date) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.customerId = customerId;
        this.itemId = itemId;
        this.date = date;
    }

    public Transaction(String name, long amount, Date date) {
        this.amount = amount;
        this.name = name;
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getItemId() {
        return itemId;
    }
}
