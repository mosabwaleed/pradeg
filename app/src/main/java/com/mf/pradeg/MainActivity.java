package com.mf.pradeg;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mf.pradeg.DataModuls.dataserves;
import com.mf.pradeg.adapter.AdapterServes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AdapterServes adapterServes;
    List<dataserves> data;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        data = new ArrayList<>();
        data.add(new dataserves(R.drawable.food,"المأكولات && الحلويات "));
        data.add(new dataserves(R.drawable.shesha,"الاراجيل"));
        data.add(new dataserves(R.drawable.asser,"العصائر"));
        data.add(new dataserves(R.drawable.ice,"ايس كريم"));
        adapterServes = new AdapterServes(this,data);
        viewPager.setAdapter(adapterServes);
    }
}
