package com.example.shayri;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Clickshayri extends Activity implements ShayriAdapter.Myclick {

    TextView click;
    String s1;
    RecyclerView rv2;
    ImageView share, faviv, copy, back, next;

    int pos = MyApp.getpos();

    ArrayList<Shayriitem> shayriitems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickshayri);

        click = findViewById(R.id.click);
        share = findViewById(R.id.share);
        faviv = findViewById(R.id.faviv);
        copy = findViewById(R.id.copy);
        rv2 = findViewById(R.id.rv2);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

        s1 = MyApp.getShayri();

//        s1 = getIntent().getExtras().getString("title");

        click.setText(s1);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rv2.setLayoutManager(gridLayoutManager);

        ShayriAdapter shayriAdapter = new ShayriAdapter(MyApp.getMylist(), Clickshayri.this, Clickshayri.this);
        rv2.setAdapter(shayriAdapter);

        dataload();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    pos--;

                    String abc = MyApp.getMylist().get(pos).getName();
                    MyApp.setShayri(abc);
                    click.setText(MyApp.getShayri());
                    dataload();

                }catch(Exception e){
                    Toast.makeText(Clickshayri.this, "Not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    pos++;

                    String abc = MyApp.getMylist().get(pos).getName();
                    MyApp.setShayri(abc);
                    click.setText(MyApp.getShayri());
                    dataload();

                } catch (Exception e) {
                    Toast.makeText(Clickshayri.this, "Not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = MyApp.getShayri();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", data);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(Clickshayri.this, "Copy Successfully", Toast.LENGTH_SHORT).show();
            }

        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = MyApp.getShayri();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        faviv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = MyApp.db.rawQuery("select * from fav where quotes = '" + MyApp.getShayri() + "'", null);

                if (cursor != null) {
                    if (cursor.moveToNext()) {
                        faviv.setImageResource(R.drawable.like_1);
                        MyApp.db.execSQL("delete from fav where quotes = '"+MyApp.getShayri()+"'");
                    }else {
                        faviv.setImageResource(R.drawable.likee);
                        MyApp.db.execSQL("insert into fav(quotes) values('"+MyApp.getShayri()+"')");
                    }
                }

            }

        });
    }

    @Override
    public void getmypos(int pos) {

        String path = MyApp.getMylist().get(pos).getName();

        MyApp.setShayri(path);

        click.setText(MyApp.getShayri());

        dataload();

    }

    public void dataload() {
        Cursor cursor = MyApp.db.rawQuery("select * from fav where quotes = '"+MyApp.getShayri()+"'", null);
        if (cursor!=null) {
            if (cursor.moveToNext()) {
                faviv.setImageResource(R.drawable.likee);
            }else{
                faviv.setImageResource(R.drawable.like_1);
            }
        }
    }
}
