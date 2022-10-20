package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String nama, String alamat) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.NAMA,nama);
        cv.put(DBHelper.ALAMAT,alamat);
        db.insert(DBHelper.TABLE,null,cv);
    }

    public Cursor fetch(){
        String[] columns = new String[] {
                DBHelper._ID,
                DBHelper.NAMA,
                DBHelper.ALAMAT
        };
        Cursor c = db.query(DBHelper.TABLE,columns,
                null,null,null,null,null);
        if (c!=null)
            c.moveToFirst();
        return c;
    }

    public int update(long _id, String nama, String alamat){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.NAMA,nama);
        cv.put(DBHelper.ALAMAT,alamat);
        int i = db.update(DBHelper.TABLE,cv,DBHelper._ID +"="+_id,null);
        return i;
    }

    public void delete(long _id) {
        db.delete(DBHelper.TABLE,DBHelper._ID+"="+_id,null);
    }

}
