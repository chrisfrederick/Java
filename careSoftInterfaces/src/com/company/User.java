package com.company;

public class User {
    protected Integer id;
    protected int pin;

    public User(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    public Integer getId() {
        return id;
    }

    public int getPin() {
        return pin;
    }
}
