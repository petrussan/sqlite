package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[]{
            DBHelper._ID,
            DBHelper.NAMA,
            DBHelper.ALAMAT
    };

    final int[] to = new int[] {
        R.id.id,R.id.nama,R.id.alamat
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        adapter = new SimpleCursorAdapter(this,R.layout.listitem,cursor,from,to,0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        String nama = "Andi";
        String alamat = "alamat ...";
        dbManager.insert(nama,alamat);
        dbManager.close();
    }
}