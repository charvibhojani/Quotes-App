package com.example.shayri;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Favourite extends AppCompatActivity implements ShayriAdapter.Myclick{

    RecyclerView rv;
    ArrayList<Shayriitem> shayriitems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_favourite);

        rv = findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        dataload();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        dataload();
    }

    public void dataload() {

        Cursor cursor = MyApp.db.rawQuery("select * from fav", null);

        if (cursor!=null) {
            while (cursor.moveToNext()) {
                String quotes = cursor.getString(0);

                shayriitems.add(mycon(quotes));

            }

            ShayriAdapter shayriAdapter = new ShayriAdapter(shayriitems, Favourite.this, Favourite.this);
            rv.setAdapter(shayriAdapter);
        }

    }

    public Shayriitem mycon(String quotes) {

        Shayriitem shayriitem = null;
        
        Cursor cursor = MyApp.db.rawQuery("select * from fav where quotes='" + quotes + "'", null);
        if (cursor != null) {

            if (cursor.moveToNext()) {
                String quote = cursor.getString(0);

                Log.d("TAG", "dataload: " + quote);

                shayriitem = new Shayriitem(quotes);

            }

        }

        return shayriitem;
    }

    @Override
    public void getmypos(int pos) {

    }
}
