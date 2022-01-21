package com.example.expensetrackerapp.Model;

import androidx.annotation.NonNull;

public class Category {
    private int id;
    private String name;
    private int cost;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Category() {

    }

    public Category(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Category(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    @NonNull
    @Override
    public String toString() {
        return "id:" + id + "  name: " + name + "  cost: " + cost;
    }
}
