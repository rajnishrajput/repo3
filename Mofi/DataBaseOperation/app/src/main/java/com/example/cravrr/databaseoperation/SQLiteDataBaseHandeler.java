package com.example.cravrr.databaseoperation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cravrr on 11/16/2017.
 */

public class SQLiteDataBaseHandeler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Employdb";
    private static final String TABLE_NAME="Employee";
    private static final String FName="Fname";
    private static final String LName="Lname";
    private static final String Job="Job";
    private static final String Salary="Salary";

    public SQLiteDataBaseHandeler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
