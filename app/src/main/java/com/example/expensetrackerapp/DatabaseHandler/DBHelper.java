package com.example.expensetrackerapp.DatabaseHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.expensetrackerapp.Model.Category;
import com.example.expensetrackerapp.Model.Expense;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
        //Log.d("tag", "Ctor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("tag", "onCreate");
        String CATEGORY_TABLE = "Create table " + Params.TABLE_CATEGORY + " ( "
                + Params.KEY_CATEGORY_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Params.KEY_CATEGORY_NAME + " TEXT NOT NULL, "
                + Params.KEY_CATEGORY_COST + " INTEGER NOT NULL "
                + " )";

        String EXPENSE_TABLE = "Create table " + Params.TABLE_EXPENSE + " ( "
                + Params.KEY_EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Params.KEY_EXPENSE_NAME + " TEXT NOT NULL, "
                + Params.KEY_EXPENSE_CATEGORY_ID + " INTEGER NOT NULL, "
                + Params.KEY_EXPENSE_DATE + " TEXT NOT NULL, "
                + Params.KEY_EXPENSE_DESCRIPTION + " TEXT NOT NULL, "
                + Params.KEY_EXPENSE_COST + " REAL  NOT NULL , "
                + " FOREIGN KEY(" + Params.KEY_EXPENSE_CATEGORY_ID + ")" + " REFERENCES " + Params.TABLE_CATEGORY + "(" + Params.KEY_CATEGORY_ID + ") "
                + ")";

        Log.d("tag", CATEGORY_TABLE);
        Log.d("tag", EXPENSE_TABLE);

        db.execSQL(CATEGORY_TABLE);
        db.execSQL(EXPENSE_TABLE);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addExpense(Expense expense){
//        KEY_EXPENSE_ID ,
//        String KEY_EXPENSE_NAME ,
//        String KEY_EXPENSE_CATEGORY_ID
//        String KEY_EXPENSE_DESCRIPTION
//        String KEY_EXPENSE_DATE
//        String KEY_EXPENSE_COST
        SQLiteDatabase db = this .getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_EXPENSE_NAME, expense.getName());
        values.put(Params.KEY_EXPENSE_CATEGORY_ID, expense.getCategory_id());
        values.put(Params.KEY_EXPENSE_DESCRIPTION, expense.getDescription());
        values.put(Params.KEY_EXPENSE_DATE,expense.getDateTime());
        values.put(Params.KEY_EXPENSE_COST, expense.getCost());

    }
    public void addCategory(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_CATEGORY_NAME, category.getName());
        values.put(Params.KEY_CATEGORY_COST, category.getCost());

        // insert into item VALUES(1 , "glass","desc" )
        db.insert(Params.TABLE_CATEGORY, null, values);
        db.close();
        Log.d("tag", "inserted successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // clear all data
//        db.execSQL("DROP TABLE IF EXISTS " + Params.TABLE_CATEGORY);
//        db.execSQL("DROP TABLE IF EXISTS " + Params.TABLE_EXPENSE);

        // recreate the tables
//        onCreate(db);
    }

    public ArrayList<Category> getALlCategories(){
        ArrayList<Category> categoryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Params.TABLE_CATEGORY;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(Integer.parseInt(cursor.getString(0)));
                category.setName(cursor.getString(1));
                category.setCost(Integer.parseInt(cursor.getString(2)));
                categoryList.add(category);
            } while (cursor.moveToNext());
        }
//        for(Category c:categoryList)
//        {
//            Log.d("tag", c.toString());
//        }
        return categoryList;
    }
}
