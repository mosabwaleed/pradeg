package com.mf.pradeg.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.mf.pradeg.R;
import com.mf.pradeg.SubServes;
import com.mf.pradeg.DataModuls.dataserves;
import java.util.List;
public class AdapterServes extends PagerAdapter {
    LayoutInflater layoutInflater;
    Context context;
    List<dataserves> data;
    dataserves s;
    @Override
    public int getCount() {
        return data.size();
    }

    public AdapterServes(Context context,List<dataserves>data){
        this.context=context;
        this.data=data;

    }
    @Override
    public boolean isViewFromObject( View view, Object o) {
        return view.equals(o);
    }
    @Override
    public Object instantiateItem( final ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);
        ImageView type = view.findViewById(R.id.typeserves);
        s = data.get(position);
        type.setImageResource(s.getImg());
        TextView title  = view.findViewById(R.id.nameserves);
        title.setText(s.getTitle());
        container.addView(view,0);
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SubServes.class);
                intent.putExtra("type",position);
                context.startActivity(intent);

                if (position==0){
                    Toast.makeText(context, "وجبات ", Toast.LENGTH_SHORT).show();
                }
                if (position==1){
                    Toast.makeText(context, "ارجيلة ", Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(context, "عصائر ", Toast.LENGTH_SHORT).show();
                }
                if (position==3){
                    Toast.makeText(context, "ايس كريم ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView((View)object) ;
    }
}