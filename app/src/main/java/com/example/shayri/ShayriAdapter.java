package com.example.shayri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShayriAdapter extends RecyclerView.Adapter<ShayriAdapter.Myh> {

    ArrayList<Shayriitem> shayriitems;
    Context context;
    Myclick myclick;

    public ShayriAdapter(ArrayList<Shayriitem> shayriitems, Context context, Myclick myclick) {

        this.shayriitems = shayriitems;
        this.context = context;
        this.myclick = myclick;
    }

    @NonNull
    @Override
    public ShayriAdapter.Myh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_shayri, parent, false);
        return new Myh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShayriAdapter.Myh holder, int position) {
        holder.shayri.setText(shayriitems.get(position).getName());

        holder.lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myclick.getmypos(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shayriitems.size();
    }

    public class Myh extends RecyclerView.ViewHolder {
        TextView shayri;
        LinearLayout lv;

        public Myh(@NonNull View itemView) {
            super(itemView);

            shayri = itemView.findViewById(R.id.shayri);
            lv = itemView.findViewById(R.id.lv);
        }
    }

    public interface Myclick {
        public void getmypos(int pos);

    }
}
