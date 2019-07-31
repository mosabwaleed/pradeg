package com.mf.pradeg.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.mf.pradeg.DataModuls.Servesitem;
import com.mf.pradeg.MainActivity;
import com.mf.pradeg.R;
import com.mf.pradeg.SharedPreference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serves extends RecyclerView.Adapter<Serves.ViewHolder>  {
    TextView name,price,desc;
    List<Servesitem>serves;
    Context context;
    Servesitem servesitem;
    LayoutInflater layoutInflater;
    LinearLayout order;
    SharedPreference sharedPreference;
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
     sharedPreference = new SharedPreference();
      return  new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull Serves.ViewHolder viewHolder, final int i) {

        servesitem = serves.get(i);
        name.setText(servesitem.getName());
        desc.setText(servesitem.getDisc());
        price.setText(servesitem.getPrice());
        if (servesitem.getName().equals("--------------------")&&servesitem.getPrice().equals("--------------------"))
        {
            desc.setTextSize(40);
           desc.setTextColor(Color.parseColor("#961817"));
        }
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(servesitem.getName().equals("--------------------") && servesitem.getPrice().equals("--------------------"))) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                    alertDialog.setTitle( "الطلب : "+serves.get(i).getName());
                    alertDialog.setMessage(" السعر : "+serves.get(i).getPrice());
                    final EditText input = new EditText(context);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT);
                    input.setLayoutParams(lp);
                    input.setHint("الكمية");
                    input.setText("1");
                    alertDialog.setView(input);
                    alertDialog.setPositiveButton("اطلب", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i1) {
                            if(sharedPreference.getFavorites(context).size()>0) {
                                for (int j = 0; j < sharedPreference.getFavorites(context).size(); j++) {
                                    if (sharedPreference.getFavorites(context).get(j).get("name").equalsIgnoreCase(serves.get(i).getName())) {
                                        int q = Integer.parseInt(sharedPreference.getFavorites(context).get(j).get("quantity"));
                                        q += Integer.parseInt(input.getText().toString());
                                        sharedPreference.removeFavorite(context, j);
                                        Map<String, String> orders = new HashMap<>();
                                        orders.put("name", serves.get(i).getName());
                                        orders.put("price", serves.get(i).getPrice());
                                        orders.put("quantity", q + "");
                                        sharedPreference.addFavorite(context, orders);
                                        break;
                                    } else if (j == sharedPreference.getFavorites(context).size() - 1) {
                                        Map<String, String> orders = new HashMap<>();
                                        orders.put("name", serves.get(i).getName());
                                        orders.put("price", serves.get(i).getPrice());
                                        orders.put("quantity", input.getText().toString());
                                        sharedPreference.addFavorite(context, orders);
                                    }
                                }
                            }
                            else {
                            Map<String,String> orders = new HashMap<>();
                            orders.put("name",serves.get(i).getName());
                            orders.put("price",serves.get(i).getPrice());
                            orders.put("quantity",input.getText().toString());
                            sharedPreference.addFavorite(context,orders);}

                            dialogInterface.dismiss();
                        }
                    });
                    alertDialog.setNegativeButton("الغاء", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
            }
        });
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
            order = v.findViewById(R.id.order);

            }
        }
    }




