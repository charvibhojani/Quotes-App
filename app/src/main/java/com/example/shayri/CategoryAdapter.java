package com.example.shayri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Myh> {

    ArrayList<Categoryitem> categoryitems;
    Context context;
    Myclick myclick;

    public CategoryAdapter(ArrayList<Categoryitem> categoryitems, Context context, Myclick myclick) {
        this.categoryitems = categoryitems;
        this.context = context;
        this.myclick = myclick;
    }

    @NonNull
    @Override
    public Myh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_category, parent, false);

        return new Myh(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Myh holder, int position) {

        holder.tv1.setText(categoryitems.get(position).getName());

        holder.ly.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                myclick.getmypos(position);
            }

        });

    }

    @Override
    public int getItemCount()   {
        return categoryitems.size();
    }

    public class Myh extends RecyclerView.ViewHolder {

        TextView tv1;
        LinearLayout ly;
        ImageView iv;
        ImageView image;

        public Myh(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            ly = itemView.findViewById(R.id.ly);
//            iv = itemView.findViewById(R.id.iv);
//            image = itemView.findViewById(R.id.image);
        }
    }

    public interface Myclick {
        public void getmypos(int pos);
    }
}