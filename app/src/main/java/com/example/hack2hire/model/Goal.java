package com.example.hack2hire.model;

public class Goal {

    private int id;

    private String name;

    private long amount;

    private int priorityId;

    public Goal(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }

    public int getPriorityId() {
        return priorityId;
    }
}
