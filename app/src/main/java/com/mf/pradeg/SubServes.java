package com.mf.pradeg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mf.pradeg.DataModuls.Servesitem;
import com.mf.pradeg.adapter.Serves;

import java.util.ArrayList;
import java.util.List;

public class SubServes extends AppCompatActivity {

    List<Servesitem>servesitems;
    Serves serves;
    RecyclerView recyclerView;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_serves);
        servesitems = new ArrayList<>();
        Intent intent = getIntent();
        position = intent.getIntExtra("type", 0);
        serves = new Serves(this, servesitems);
        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(serves);

        if (position == 0) {
            servesitems.add(new Servesitem("--------------------", "السناكات", "--------------------"));
            servesitems.add(new Servesitem("تندر", "--", "2.00"));
            servesitems.add(new Servesitem("زنجر", "--", "2.00"));
            servesitems.add(new Servesitem("سكالوب", "--", "2.00"));
            servesitems.add(new Servesitem("برجر", "--", "2.00"));
            servesitems.add(new Servesitem("فاهيتا", "--", "2.00"));
            servesitems.add(new Servesitem("كوردن بلو", "--", "1.00"));
            servesitems.add(new Servesitem("فرينش فرايد", "--", "1.50"));
            servesitems.add(new Servesitem("حلوم", "--", "1.50"));
            servesitems.add(new Servesitem("ويدجز", "--", "1.50"));
            servesitems.add(new Servesitem("هوت دوج", "--", "1.50"));
            servesitems.add(new Servesitem("--------------------", "السلطات", "--------------------"));
            servesitems.add(new Servesitem("سيزر سلات", "--", "2.00"));
            servesitems.add(new Servesitem("حربك", "--", "2.00"));
            servesitems.add(new Servesitem("روكا", "--", "2.00"));
            servesitems.add(new Servesitem("جرين سلات", "--", "2.00"));
            servesitems.add(new Servesitem("--------------------", "الحلويات ", "--------------------"));
            servesitems.add(new Servesitem("وافل", "--", "2.00"));
            servesitems.add(new Servesitem("كريب", "--", "2.00"));
            servesitems.add(new Servesitem("اي اضافه", "--", "1.00"));

        }
         if (position == 1) {
            servesitems.add(new Servesitem("--------------------", "الاراجيل", "--------------------"));
            servesitems.add(new Servesitem("ليمون و نعنع", "--", "2.00"));
            servesitems.add(new Servesitem("علكة و قرفة", "--", "2.00"));
            servesitems.add(new Servesitem("عنب و نعنع", "--", "2.00"));
            servesitems.add(new Servesitem("توت و عنب", "--", "2.00"));
            servesitems.add(new Servesitem("بطيخ و نعنع", "--", "2.00"));
            servesitems.add(new Servesitem("بلوبيري توت", "--", "2.00"));
            servesitems.add(new Servesitem("عنب", "--", "2.00"));
            servesitems.add(new Servesitem("تفاحتين مزايا", "--", "2.00"));
            servesitems.add(new Servesitem("تفاحتين نخلة", "--", "3.00"));
            servesitems.add(new Servesitem("فخفخينا", "--", "2.00"));
            servesitems.add(new Servesitem("كيف", "--", "2.00"));
            servesitems.add(new Servesitem("علكة ونعنع", "--", "2.00"));
            servesitems.add(new Servesitem("ارجيلة بريدج", "--", "3.00"));
            servesitems.add(new Servesitem("اضافة راس", "--", "1.00"));}

         if (position==2){
             Toast.makeText(this, "Biscut", Toast.LENGTH_SHORT).show();
         }

            if (position == 3) {
                servesitems.add(new Servesitem("--------------------", "ايس كريم", "--------------------"));
                servesitems.add(new Servesitem("بنانا سبلت", "فانيلا,شوكولاته,فراولة,موز,تقدم مع شراب شوكولاته", "2.00"));
                servesitems.add(new Servesitem("شوكولامو", "ثلاث طبقات ايس كريم الشوكولاته مغطاة بطبقة من المكسرات وشراب الكوكولاته,(جميع النكهات)", "2.00"));
                servesitems.add(new Servesitem("بريدج كوب", "فيريرور روشيه,دولوسيه عربيه,فواكه مشكله تقدم مع المكسرات وشرب الشوكولاته", "3.00"));
                servesitems.add(new Servesitem("--------------------", "المشروبات المثلجة", "--------------------"));
                servesitems.add(new Servesitem("ميلك شيك بريدج ", "--", "3.00"));
                servesitems.add(new Servesitem("قهوة مثلجة", "قهوة وثلج", "2.50"));
                servesitems.add(new Servesitem("فربتشينو", "فانيلا , ايس كريم, اسبرسو, حليب, ثلج ", "2.50"));
                servesitems.add(new Servesitem("ايس موكا", "فانيلا , شوكولاتة , نسكافية , حليب , ثلج", "2.50"));
                servesitems.add(new Servesitem("ميلك شيك", "نكهات", "2.50"));

            }

        }

    }

