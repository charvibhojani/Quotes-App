package com.example.shayri;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayri.databinding.ActivityCategoryBinding;
import com.example.shayri.databinding.ListCategoryBinding;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements CategoryAdapter.Myclick {

    ActivityCategoryBinding activityCategoryBinding;

    String select = "";
    ArrayList<Categoryitem> categoryitems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityCategoryBinding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(activityCategoryBinding.getRoot());

        registerNetworkBroadcastForNougat();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-event-name"));

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_200)));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        activityCategoryBinding.lv.setLayoutManager(linearLayoutManager);

        categoryitems.add(new Categoryitem("Happy"));
        categoryitems.add(new Categoryitem("Love"));
        categoryitems.add(new Categoryitem("Inspirational"));
        categoryitems.add(new Categoryitem("Birthday"));
        categoryitems.add(new Categoryitem("Motivational"));
        categoryitems.add(new Categoryitem("Success"));
        categoryitems.add(new Categoryitem("Friends"));
        categoryitems.add(new Categoryitem("Anniversary"));
        categoryitems.add(new Categoryitem("Sad"));
        categoryitems.add(new Categoryitem("Alone"));

        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryitems, CategoryActivity.this, CategoryActivity.this);
        activityCategoryBinding.lv.setAdapter(categoryAdapter);

        activityCategoryBinding.favv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, Favourite.class);
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void registerNetworkBroadcastForNougat() {
        registerReceiver(new NetCheckReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("message");

            if (message.equalsIgnoreCase("on")) {

                activityCategoryBinding.data.setVisibility(View.VISIBLE);
                activityCategoryBinding.nodata.setVisibility(View.GONE);
            } else {
                activityCategoryBinding.data.setVisibility(View.GONE);
                activityCategoryBinding.nodata.setVisibility(View.VISIBLE);
            }
        }
    };

    public void getmypos(int pos) {

        select = categoryitems.get(pos).getName();

        MyApp.setShayri(select);

        Toast.makeText(CategoryActivity.this, select, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(CategoryActivity.this, ShayriActivity.class);

//        intent.putExtra("title", select);

        startActivity(intent);
    }
}