package com.example.demo;

import java.io.Serializable;

public class iteminfo implements Serializable {
    private String name;
    private int acctack;
    private int left;
    private int speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcctack() {
        return acctack;
    }

    public void setAcctack(int acctack) {
        this.acctack = acctack;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public iteminfo(String name, int acctack, int left, int speed) {
        this.name = name;
        this.acctack = acctack;
        this.left = left;
        this.speed = speed;
    }
}
