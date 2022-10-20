package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE = "CONTACT";
    public static final String _ID = "_id";
    public static final String NAMA = "nama";
    public static final String ALAMAT = "alamat";

    private static final String DB_NAME = "mydb.db";
    private static final int DB_VERSION = 1;
    private static final String CREATE_TABLE =
            "create table " + TABLE +"(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ""+NAMA+ " TEXT NOT NULL, "+ALAMAT+" TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(sqLiteDatabase);
    }
}
