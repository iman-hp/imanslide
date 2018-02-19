package com.vasiqimarket.www.imanslide;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Integer[]img={R.drawable.pic2,R.drawable.pic1};
        Button btnnext=(Button)findViewById(R.id.btnnext);
        Button btnprev=(Button)findViewById(R.id.btnprev);
        final ImageSwitcher is=(ImageSwitcher)findViewById(R.id.is);

        is.setFactory(new ImageSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView img=new ImageView(getApplicationContext());
                img.setScaleType(ImageView.ScaleType.FIT_CENTER);
                img.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));



                return img;
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation in= AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_in_left);
                Animation out= AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_out_right);
                is.setAnimation(in);
                is.setAnimation(out);
                is.setImageResource(img[0]);
            }
        });
        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation in= AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_in_left);
                Animation out= AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_out_right);
                is.setAnimation(in);
                is.setAnimation(out);
                is.setImageResource(img[1]);
            }
        });
    }
}
