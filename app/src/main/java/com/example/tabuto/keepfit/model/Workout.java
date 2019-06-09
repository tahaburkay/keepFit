package com.example.tabuto.keepfit.model;

public class Workout {

    private String _id;
    private String name;
    private int amount;
    private int setSize;
    private String descripton;
    private String gender;
    private String body_index;

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getSetSize() {
        return setSize;
    }

    public String getDescripton() {
        return descripton;
    }

    public String getGender() {
        return gender;
    }

    public String getBody_index() {
        return body_index;
    }
}
