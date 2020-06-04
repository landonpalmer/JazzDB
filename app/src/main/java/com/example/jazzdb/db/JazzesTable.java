package com.example.jazzdb.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class JazzesTable {

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

        public JazzesTable(Context context) {
            dbHelper = new DBHelper(context);
        }

        public void openDB() {
            sqLiteDatabase = dbHelper.getWritableDatabase();
        }

        public void closeDB() {
            sqLiteDatabase.close();
        }

        public void insertRecord(String jname, String jnumber) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBHelper.COL_JNAME, jname);
            contentValues.put(DBHelper.COL_JNUMBER, jnumber);

            sqLiteDatabase.insert(DBHelper.TABLE_JNAME, null, contentValues);

        }

        public Cursor getAllRecords(){
            return sqLiteDatabase.rawQuery("select * from " + DBHelper.TABLE_JNAME, null);
        }
}
