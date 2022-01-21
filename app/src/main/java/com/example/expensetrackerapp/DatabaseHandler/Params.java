package com.example.expensetrackerapp.DatabaseHandler;

public class Params {


    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "expense_tracker_db.db";
    public static final String TABLE_CATEGORY = "category";
    public static final String TABLE_EXPENSE = "expense";


    //Keys of our category table in db
    public static final String KEY_CATEGORY_ID = "id";
    public static final String KEY_CATEGORY_NAME = "name";
    public static final String KEY_CATEGORY_COST = "total_cost";

    //Keys of our expense table in db
    public static final String KEY_EXPENSE_ID = "id";
    public static final String KEY_EXPENSE_NAME = "name";
    public static final String KEY_EXPENSE_CATEGORY_ID = "category_id";
    public static final String KEY_EXPENSE_DESCRIPTION = "description";
    public static final String KEY_EXPENSE_DATE = "date";
    public static final String KEY_EXPENSE_COST = "cost";


}
