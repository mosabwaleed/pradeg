package com.mf.pradeg;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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
    LinearLayout jous;
    ImageView hot,cold,coc,jo;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_serves);
        servesitems = new ArrayList<>();
        hot = findViewById(R.id.hot);
        cold = findViewById(R.id.bared);
        coc = findViewById(R.id.kokteel);
        jo = findViewById(R.id.aseer);
        jous = findViewById(R.id.jous);
        Intent intent = getIntent();
        position = intent.getIntExtra("type", 0);

        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        serves = new Serves(this, servesitems);
        recyclerView.setAdapter(serves);

        if (position == 0) {
            recyclerView.setVisibility(View.VISIBLE);
            servesitems.add(new Servesitem("--------------------", "السناكات", "--------------------"));
            servesitems.add(new Servesitem("تندر", "", "2.00"));
            servesitems.add(new Servesitem("زنجر", "", "2.00"));
            servesitems.add(new Servesitem("سكالوب", "", "2.00"));
            servesitems.add(new Servesitem("برجر", "", "2.00"));
            servesitems.add(new Servesitem("فاهيتا", "", "2.00"));
            servesitems.add(new Servesitem("كوردن بلو", "", "1.00"));
            servesitems.add(new Servesitem("فرينش فرايد", "", "1.50"));
            servesitems.add(new Servesitem("حلوم", "", "1.50"));
            servesitems.add(new Servesitem("ويدجز", "", "1.50"));
            servesitems.add(new Servesitem("هوت دوج", "", "1.50"));
            servesitems.add(new Servesitem("--------------------", "السلطات", "--------------------"));
            servesitems.add(new Servesitem("سيزر سلات", "", "2.00"));
            servesitems.add(new Servesitem("حربك", "", "2.00"));
            servesitems.add(new Servesitem("روكا", "", "2.00"));
            servesitems.add(new Servesitem("جرين سلات", "", "2.00"));
            servesitems.add(new Servesitem("--------------------", "الحلويات ", "--------------------"));
            servesitems.add(new Servesitem("وافل", "", "2.00"));
            servesitems.add(new Servesitem("كريب", "", "2.00"));
            servesitems.add(new Servesitem("اي اضافه", "--", "1.00"));

        }
         if (position == 1) {
             recyclerView.setVisibility(View.VISIBLE);
            servesitems.add(new Servesitem("--------------------", "الاراجيل", "--------------------"));
            servesitems.add(new Servesitem("ليمون و نعنع", "", "2.00"));
            servesitems.add(new Servesitem("علكة و قرفة", "", "2.00"));
            servesitems.add(new Servesitem("عنب و نعنع", "", "2.00"));
            servesitems.add(new Servesitem("توت و عنب", "", "2.00"));
            servesitems.add(new Servesitem("بطيخ و نعنع", "", "2.00"));
            servesitems.add(new Servesitem("بلوبيري توت", "", "2.00"));
            servesitems.add(new Servesitem("عنب", "", "2.00"));
            servesitems.add(new Servesitem("تفاحتين مزايا", "", "2.00"));
            servesitems.add(new Servesitem("تفاحتين نخلة", "", "3.00"));
            servesitems.add(new Servesitem("فخفخينا", "", "2.00"));
            servesitems.add(new Servesitem("كيف", "", "2.00"));
            servesitems.add(new Servesitem("علكة ونعنع", "", "2.00"));
            servesitems.add(new Servesitem("ارجيلة بريدج", "", "3.00"));
            servesitems.add(new Servesitem("اضافة راس", "", "1.00"));}

         if (position==2){
             recyclerView.setVisibility(View.GONE);
             jous.setVisibility(View.VISIBLE);
         }

            if (position == 3) {
                recyclerView.setVisibility(View.VISIBLE);
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
            serves = new Serves(this, servesitems);
            recyclerView.setAdapter(serves);
            coc.setOnClickListener(this.onClickListener(R.id.kokteel,this,"coc"));
            cold.setOnClickListener(this.onClickListener(R.id.bared,this,"cold"));
            hot.setOnClickListener(this.onClickListener(R.id.hot,this,"hot"));
            jo.setOnClickListener(this.onClickListener(R.id.aseer,this,"jo"));
        }
    public View.OnClickListener onClickListener( Integer id,  final Context con, final String content){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jous.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                System.out.println(content + "      content");
                if (position==2&&content.equals("hot")){
                    servesitems.add(new Servesitem("--------------------", "المشروبات الساخنة", "--------------------"));
                    servesitems.add(new Servesitem("قهوة بريدج", "", "2.00"));
                    servesitems.add(new Servesitem("قهوة فرنسية", "", "2.00"));
                    servesitems.add(new Servesitem("قهوة امريكية", "", "2.00"));
                    servesitems.add(new Servesitem("كوفي لاتية", "", "2.00"));
                    servesitems.add(new Servesitem("قهوة تركية", "", "1.00"));
                    servesitems.add(new Servesitem("قهوة تركية دبل", "", "1.50"));
                    servesitems.add(new Servesitem("اسبرسو", "", "1.50"));
                    servesitems.add(new Servesitem("نيسكافية", "", "1.00"));
                    servesitems.add(new Servesitem("كابتسينو ", "", "2.00"));
                    servesitems.add(new Servesitem("موكا تشينو", "", "1.00"));
                    servesitems.add(new Servesitem("شاي ", "", "1.00"));
                    servesitems.add(new Servesitem("اعشاب", "", "1.00"));
                    servesitems.add(new Servesitem("نسكويك", "", "2.00"));
                }
                else if (position==2&&content.equals("coc")){
                    servesitems.add(new Servesitem("--------------------", "الكوكتيل", "--------------------"));
                    servesitems.add(new Servesitem("كوكتيل بريدج", "خلطة خاصة", "3.00"));
                    servesitems.add(new Servesitem("دايت كوكتيل", "برتقال ,ليمون ,جريفوت, جراندن", "2.50"));
                    servesitems.add(new Servesitem("فروت بنش", "فراولة ,مانجا,موز,حليب", "2.00"));
                    servesitems.add(new Servesitem("سمر لايت", "مشمش, موز, برتقال", "2.50"));
                    servesitems.add(new Servesitem("جمايكا", "برتقال ,اناناس ,جراندن ", "2.50"));
                    servesitems.add(new Servesitem("فينانا كوكتيل", "موز , فيمتو , حليب ,فانيلا , ايس كريم", "2.50"));
                    servesitems.add(new Servesitem("كوكتيل الطاقة", "ريد بول ,كيوي ,عسل ,جوافة ,مانجا", "2.50"));
                    servesitems.add(new Servesitem("كوكتيل مكس ", "موز , حليب ,فراولة, تفاح, مانجا, اناناس", "2.50"));
                    servesitems.add(new Servesitem("كوكتيل منى", "فانيلا , كيوي , برتقال", "2.50"));
                    servesitems.add(new Servesitem("صن ست ", "فراولة , مانجا , باش فروت", "2.50"));
                    servesitems.add(new Servesitem("فروت سلد", "فواكة مشكلة, عصير برتقال", "3.50"));
                    servesitems.add(new Servesitem("ليليانا كوكتيل", "فراولة, موز , ايس كريم فانيلا, حليب", "3.00"));
                }
                else if (position==2&&content.equals("cold")){
                    servesitems.add(new Servesitem("--------------------", "المشروبات الغازية", "--------------------"));
                    servesitems.add(new Servesitem("بترلمون", "", "1.00"));
                    servesitems.add(new Servesitem("ريد بول", "", "2.00"));
                    servesitems.add(new Servesitem("اكس ال", "", "1.50"));
                    servesitems.add(new Servesitem("جراندين", "", "1.50"));
                    servesitems.add(new Servesitem("بنك ليمونيد", "", "2.00"));
                    servesitems.add(new Servesitem("بيبسي", "", "1.00"));
                    servesitems.add(new Servesitem("ميرندا", "", "1.00"));
                    servesitems.add(new Servesitem("سفن اب", "", "1.00"));
                    servesitems.add(new Servesitem("بابركان نكهات ", "", "1.50"));
                    servesitems.add(new Servesitem("مياه", "", ".50"));
                }
                else if (position==2&&content.equals("jo")){
                    servesitems.add(new Servesitem("--------------------", "العصائر", "--------------------"));
                    servesitems.add(new Servesitem("برتقال", "", "2.00"));
                    servesitems.add(new Servesitem("اناناس", "", "2.00"));
                    servesitems.add(new Servesitem("فراولة", "", "2.00"));
                    servesitems.add(new Servesitem("ليمون و نعنع", "", "2.00"));
                    servesitems.add(new Servesitem("ليمون سموزي", "", "2.00"));
                    servesitems.add(new Servesitem("جوافة", "", "2.00"));
                    servesitems.add(new Servesitem("تفاح", "", "2.00"));
                    servesitems.add(new Servesitem("جزر", "", "2.00"));
                    servesitems.add(new Servesitem("كيوي ", "", "2.00"));
                    servesitems.add(new Servesitem("منجا", "", "2.00"));
                    servesitems.add(new Servesitem("كيوي و ليمون و نعنع ", "", "2.50"));
                    servesitems.add(new Servesitem("برتقال و جزر", "", "2.00"));
                }
                serves = new Serves(SubServes.this, servesitems);
                recyclerView.setAdapter(serves);
            }
        };
    }

    @Override
    public void onBackPressed() {
        if(recyclerView.getVisibility()==View.VISIBLE){
            recyclerView.setVisibility(View.GONE);
            jous.setVisibility(View.VISIBLE);
            servesitems.clear();
            serves =null;
            System.out.println(servesitems.size() + "       size");
        }

        else {
            super.onBackPressed();
        }
    }
}

