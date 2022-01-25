package com.example.expensetrackerapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.expensetrackerapp.Adapters.CategoryRVAdapter;
import com.example.expensetrackerapp.DatabaseHandler.DBHelper;
import com.example.expensetrackerapp.Model.Category;
import com.example.expensetrackerapp.Model.Expense;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private ArrayList<Category> courseModalArrayList;
    private DBHelper db;
    private RecyclerView categoryRecyclerView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBHelper db = new DBHelper(MainActivity.this);

        db = new DBHelper(MainActivity.this);

        // to show categories list in recyclerview
        courseModalArrayList = db.getALlCategories();
        categoryRecyclerView = findViewById(R.id.idRVCategory);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        CategoryRVAdapter categoryRVAdapter = new CategoryRVAdapter(this.courseModalArrayList, MainActivity.this);
        categoryRecyclerView.setAdapter(categoryRVAdapter);

        //  expenses

//        db.addExpense(new Expense("Burger", 2, "burger", 200));
//        db.addExpense(new Expense("Pizza", 2, "Pizza", 300));

//        displaying expenses as model
//        ArrayList<Expense> expenses = db.getExpensesByCategory(1);
//        StringBuilder str = new StringBuilder();
//        for (Expense c : expenses) {
//            str.append(c.toString());
//            Log.d("tag", c.toString());
//        }
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder1.setMessage(str);
//        AlertDialog alert11 = builder1.create();
//        alert11.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //  this method will run when our menu bar is created

        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return true; // true means we have successfully inflated our own menu_bar
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_image:
                Toast.makeText(this, "Image Icon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_Exit:
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}