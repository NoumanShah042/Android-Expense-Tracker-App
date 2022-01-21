package com.example.expensetrackerapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.expensetrackerapp.DatabaseHandler.DBHelper;
import com.example.expensetrackerapp.Model.Category;
import com.example.expensetrackerapp.Model.Expense;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBHelper db = new DBHelper(MainActivity.this);
//        String name, int category_id , String description, int cost
        Expense e= new  Expense("Petrol", 1, "Desc", 300);
        Log.d("tag",e.toString());
//        Category c = new Category("Food", 300);
//        db.addCategory(c);
//        db.getALlCategories();




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