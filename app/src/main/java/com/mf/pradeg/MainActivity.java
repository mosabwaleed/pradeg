package com.mf.pradeg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mf.pradeg.DataModuls.dataserves;
import com.mf.pradeg.adapter.AdapterServes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AdapterServes adapterServes;
    List<dataserves> data;
    ViewPager viewPager;
    ImageView setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        setting = findViewById(R.id.setting);
        data = new ArrayList<>();
        data.add(new dataserves(R.drawable.food,"المأكولات && الحلويات "));
        data.add(new dataserves(R.drawable.shesha,"الاراجيل"));
        data.add(new dataserves(R.drawable.asser,"العصائر"));
        data.add(new dataserves(R.drawable.ice,"ايس كريم"));
        adapterServes = new AdapterServes(this,data);
        viewPager.setAdapter(adapterServes);


        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("ادخل الباسوورد لتعديل رقم الطاولة");
                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setInputType(InputType.TYPE_CLASS_TEXT |
                        InputType.TYPE_TEXT_VARIATION_PASSWORD);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setPositiveButton("تم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(input.getText().toString().equalsIgnoreCase("mo3en")){
                            dialogInterface.dismiss();

                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                            alertDialog.setTitle("ادخل رقم الطاولة");
                            final EditText input = new EditText(MainActivity.this);
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.MATCH_PARENT);
                            input.setLayoutParams(lp);
                            alertDialog.setView(input);
                            input.setText(getPrefs("tnum",MainActivity.this));
                            alertDialog.setPositiveButton("تم", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    setPrefs("tnum",input.getText().toString(),MainActivity.this);
                                        dialogInterface.dismiss();

                                }
                            });
                            alertDialog.show();

                        }
                        else {
                            dialogInterface.dismiss();
                        }
                    }
                });
                alertDialog.show();

            }
        });
    }
    public static void setPrefs(String key, String value, Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences("mosab_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getPrefs(String key, Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences("mosab_prefs", Context.MODE_PRIVATE);
        return sharedpreferences.getString(key,"notfound");
    }
}
