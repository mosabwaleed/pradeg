package com.mf.pradeg.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mf.pradeg.DataModuls.Servesitem;
import com.mf.pradeg.R;

import java.util.List;

public class Serves extends RecyclerView.Adapter<Serves.ViewHolder>  {
    TextView name;
    TextView desc;
    TextView price;
    List<Servesitem>serves;
    Context context;
    CardView cardView;
    Servesitem servesitem;
    LayoutInflater layoutInflater;
    ViewHolder viewHolder;
    private static final int TYPE_FEATURED = 1;
    private static final int TYPE_OTHER = 2;


    public Serves(Context context, List<Servesitem>serves){
        this.context=context;
        this.serves=serves;
    }
    @Override
    public Serves.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
     layoutInflater = LayoutInflater.from(viewGroup.getContext());
  View  view1 = layoutInflater.inflate(R.layout.itemserves, viewGroup, false);

      return  new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull Serves.ViewHolder viewHolder, int i) {

        servesitem = serves.get(i);
        name.setText(servesitem.getName());
        desc.setText(servesitem.getDisc());
        price.setText(servesitem.getPrice());
        if (servesitem.getName().equals("--------------------")&&servesitem.getPrice().equals("--------------------")){

            desc.setTextSize(30);
           desc.setTextColor(Color.parseColor("#961817"));

               }
    }


    @Override
    public int getItemCount() {
        return serves.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public  ViewHolder(View v){
            super(v);
            name = v.findViewById(R.id.name);
            desc = v.findViewById(R.id.desc);
            price = v.findViewById(R.id.price);

            }
        }
    }




