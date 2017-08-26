package com.example.pavneet.techguru;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import static android.widget.Toast.makeText;

/**
 * Created by Pavneet on 09-06-2017.
 */
public class CustomSliderAdapter extends PagerAdapter {
    static ViewGroup cnt;
    static  int pos;
    Intent intent;
    private Context ctx;
    private int[] image_resources ={R.drawable.android,R.drawable.aspnet,R.drawable.angularjs,R.drawable.crm,R.drawable.salesforce,R.drawable.phpimg};
    private LayoutInflater layoutInflater;
    public CustomSliderAdapter(Context ctx){
        this.ctx=ctx;
    }
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }



        @Override
        public Object instantiateItem (ViewGroup container,final int position){
            pos=position;
            //if(position>=image_resources.length)

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        imageView.setImageResource(image_resources[position]);
        container.addView(item_view);

            item_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(position){
                        case 0:
                            intent=new Intent(v.getContext(),Details.class);
                            intent.putExtra("Course_name","Android");
                            v.getContext().startActivity(intent);
                            break;
                        case 1:
                            intent=new Intent(v.getContext(),Details.class);
                            intent.putExtra("Course_name","asp.net");
                            v.getContext().startActivity(intent);

                            break;
                        case 2:
                            intent=new Intent(v.getContext(),Details.class);
                            intent.putExtra("Course_name","Angularjs");
                            v.getContext().startActivity(intent);

                            break;
                        case 3:
                            intent=new Intent(v.getContext(),Details.class);
                            intent.putExtra("Course_name","salesforce");
                            v.getContext().startActivity(intent);

                            break;
                        case 4:
                            intent=new Intent(v.getContext(),Details.class);
                            intent.putExtra("Course_name","crm");
                            v.getContext().startActivity(intent);

                            break;
                        case 5:
                            intent=new Intent(v.getContext(),Details.class);
                            intent.putExtra("Course_name","php");
                            v.getContext().startActivity(intent);

                            break;
                    }

                }
            });
        cnt=container;
            return item_view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
