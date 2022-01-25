package com.example.expensetrackerapp;

import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.expensetrackerapp.Adapters.CategoryRVAdapter;
import com.example.expensetrackerapp.DatabaseHandler.DBHelper;
import com.example.expensetrackerapp.Model.Category;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private ArrayList<Category> courseModalArrayList;
    DBHelper db;
    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        db = new DBHelper(CategoryActivity.this);
        courseModalArrayList = db.getALlCategories();
        categoryRecyclerView = findViewById(R.id.idRVCategory);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CategoryActivity.this, RecyclerView.VERTICAL, false);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);

        CategoryRVAdapter categoryRVAdapter = new CategoryRVAdapter(this.courseModalArrayList, CategoryActivity.this);
        categoryRecyclerView.setAdapter(categoryRVAdapter);

    }
}