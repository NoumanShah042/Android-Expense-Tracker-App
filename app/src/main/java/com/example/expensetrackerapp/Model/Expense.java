package com.example.expensetrackerapp.Model;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Expense {

    private int id;
    private String name;
    private int category_id;
    private LocalDateTime dateTime = LocalDateTime.now();
    private String description;
    private int cost;

    @NonNull
    @Override
    public String toString() {
        return "id:" + id + " name:" + name + " category_id:" + category_id +
                " dateTime:" + dateTime + " description:" + description + " cost:" + cost + "\n";
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Expense(int id, String name, int category_id, String description, int cost) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
        this.description = description;
        this.cost = cost;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Expense(String name, int category_id, String description, int cost) {
        //  Expense('Food', 1, "desc", 200)
        this.name = name;
        this.category_id = category_id;
        this.description = description;
        this.cost = cost;
    }

    public Expense() {

    }


    public void setDescription(String description) {

        this.description = description;
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


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        return formattedDateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {     //  set date from actual object

        this.dateTime = dateTime;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setDateTime(String dateTime) {   //  set date from String
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        this.dateTime = LocalDateTime.parse(dateTime, formatter2);
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }


}
