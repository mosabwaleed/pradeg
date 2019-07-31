package com.mf.pradeg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart extends AppCompatActivity {
    ListView orders;
    List<Map<String, String>> saleList;
    Button clear , end;
    SimpleAdapter sAdap;
    TextView total;
    static Double totalprice =0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        total = findViewById(R.id.totalPrice);
        clear = findViewById(R.id.clearButton);
        end = findViewById(R.id.endButton);
        orders = findViewById(R.id.sale_List);
        saleList = new ArrayList<>();
        saleList = new SharedPreference().getFavorites(this);
        sAdap = new SimpleAdapter(this, saleList,
                R.layout.listview_lineitem, new String[]{"name","quantity","price"}, new int[] {R.id.name,R.id.quantity,R.id.price});
        orders.setAdapter(sAdap);

        for (int i =0 ; i<saleList.size();i++){
            Double price = Double.parseDouble(saleList.get(i).get("price"));
            totalprice += price;
        }
        total.setText(totalprice+" JD");

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharedPreference().removeall(Cart.this);
                orders.setAdapter(null);
                total.setText("0.0 JD");
                totalprice =0.0;
            }
        });
    }
}
