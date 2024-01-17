package com.example.shayri;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    ArrayList<Shayriitem> shayriitems;
    Context context;

    public ViewPagerAdapter(ArrayList<Shayriitem> shayriitems, Context context) {
        this.shayriitems = shayriitems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return shayriitems.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.viewpager_item,
                container, false);

        TextView tv = layout.findViewById(R.id.tv);

        tv.setText(shayriitems.get(position).getName());

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyApp.setShayri(shayriitems.get(position).getName());
                MyApp.setMylist(shayriitems);
                MyApp.setpos(position);

                Intent intent = new Intent(context, Clickshayri.class);
                context.startActivity(intent);

            }
        });

        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
