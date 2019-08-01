package com.mf.pradeg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart extends AppCompatActivity {
    ListView orders;
    List<Map<String, String>> saleList;
    Button clear , end;
    SimpleAdapter sAdap;
    TextView total;
    Double totalprice =0.0;
    Connection connect;
    String ConnectionResult = "";
    Boolean isSuccess = false;
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
            Double price = (Double.parseDouble(saleList.get(i).get("price")))*Double.parseDouble(saleList.get(i).get("quantity"));
            totalprice += price;
        }
        total.setText(totalprice+" JD");

        orders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Cart.this);
                final String name = new SharedPreference().getFavorites(Cart.this).get(position).get("name");
                final String price = new SharedPreference().getFavorites(Cart.this).get(position).get("price");
                alertDialog.setTitle( "الطلب : "+new SharedPreference().getFavorites(Cart.this).get(position).get("name"));
                alertDialog.setMessage(" السعر : "+new SharedPreference().getFavorites(Cart.this).get(position).get("price"));
                final EditText input = new EditText(Cart.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                input.setHint("الكمية");
                input.setText(new SharedPreference().getFavorites(Cart.this).get(position).get("quantity"));
                alertDialog.setView(input);
                alertDialog.setPositiveButton("تعديل الكمية", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new SharedPreference().removeFavorite(Cart.this,position);
                        Map<String, String> order = new HashMap<>();
                        order.put("name", name);
                        order.put("price", price);
                        order.put("quantity",input.getText().toString());
                        new SharedPreference().addFavorite(Cart.this,order);
                        saleList = new SharedPreference().getFavorites(Cart.this);
                        sAdap = new SimpleAdapter(Cart.this, saleList,
                                R.layout.listview_lineitem, new String[]{"name","quantity","price"}, new int[] {R.id.name,R.id.quantity,R.id.price});
                        orders.setAdapter(sAdap);
                        totalprice = 0.0;
                        for (int i =0 ; i<saleList.size();i++){
                            Double price = (Double.parseDouble(saleList.get(i).get("price")))*Double.parseDouble(saleList.get(i).get("quantity"));
                            totalprice += price;
                        }
                        total.setText(totalprice+" JD");
                    }
                });

                alertDialog.setNeutralButton("الغاء", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.setNegativeButton("حذف الطلب", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new SharedPreference().removeFavorite(Cart.this,position);
                        saleList = new SharedPreference().getFavorites(Cart.this);
                        sAdap = new SimpleAdapter(Cart.this, saleList,
                                R.layout.listview_lineitem, new String[]{"name","quantity","price"}, new int[] {R.id.name,R.id.quantity,R.id.price});
                        orders.setAdapter(sAdap);
                        totalprice = 0.0;
                        for (int i =0 ; i<saleList.size();i++){
                            Double price = (Double.parseDouble(saleList.get(i).get("price")))*Double.parseDouble(saleList.get(i).get("quantity"));
                            totalprice += price;
                        }
                        total.setText(totalprice+" JD");

                    }
                });
                alertDialog.show();
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharedPreference().removeall(Cart.this);
                orders.setAdapter(null);
                total.setText("0.0 JD");
                totalprice =0.0;
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectionClass conStr=new ConnectionClass();
                connect =conStr.CONN(Cart.this);
                if (connect == null)
                {
                    ConnectionResult = "Check Your Internet Access!";
                }
                else {
                    try{
                    for (int i = 0; i < saleList.size(); i++) {
                        String query = "insert into table"+getPrefs("tnum",Cart.this)+" (NAME, PRICE , quantity) values(N'"
                                + saleList.get(i).get("name") + "','" + saleList.get(i).get("price") + "','" + saleList.get(i).get("quantity") + "')";
                        PreparedStatement preparedStmt = connect.prepareStatement(query);
                        preparedStmt.execute();
                        ConnectionResult = "successful";
                        isSuccess = true;

                    }
                        connect.close();
                    }
                    catch (SQLException e){
                        isSuccess = false;
                        ConnectionResult = e.getMessage();
                    }
                    catch (Exception ex)
                    {
                        isSuccess = false;
                        ConnectionResult = ex.getMessage();
                    }
                    System.out.println(ConnectionResult + "     conni");
                }

                new SharedPreference().removeall(Cart.this);
                orders.setAdapter(null);
                total.setText("0.0 JD");
                totalprice =0.0;
            }
        });
    }

    public static String getPrefs(String key, Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences("mosab_prefs", Context.MODE_PRIVATE);
        return sharedpreferences.getString(key,"notfound");
    }
}