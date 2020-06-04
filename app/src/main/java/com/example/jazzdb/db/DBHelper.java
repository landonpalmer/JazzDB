package com.example.jazzdb.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "jazzdb";
    private static final int DB_VERSION = 1;

    public static final String TABLE_JNAME = "jazzes";
    public static final String COL_JROWID = "jrowid";
    public static final String COL_JNAME = "jname";
    public static final String COL_JNUMBER = "jnumber";

    String CREATE_JTABLE = "create table jazzes(jrowid INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "jname text,jnumber text )";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_JTABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

