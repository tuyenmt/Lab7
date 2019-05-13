package com.example.lab7;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {

    Button btnRotation, btnZoom, btnMoving;
    ImageView imgView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        btnMoving=(Button)findViewById(R.id.btnMoving);
        btnRotation =(Button)findViewById(R.id.btnRotation);
        btnZoom = (Button)findViewById(R.id.btnZoom);
        imgView = (ImageView)findViewById(R.id.imageView);

        btnRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int  dest = 1080;
              if (imgView.getRotation() == 1080){
                  System.out.println(imgView.getAlpha());
                  dest = 0;
              }
              ObjectAnimator animation1 = ObjectAnimator.ofFloat(imgView,"rotation",dest);
              animation1.setDuration(4000);
              animation1.start();
            }
        });

        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imgView.setImageResource(R.drawable.all);
//                AnimationDrawable animationDrawable = (AnimationDrawable)imgView.getDrawable();
//                animationDrawable.start();

                android.view.animation.Animation zoom = (android.view.animation.Animation) AnimationUtils.loadAnimation(Animation.this,R.anim.zoom);
                imgView.startAnimation(zoom);

            }
        });

        btnMoving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator animation = ObjectAnimator.ofFloat(imgView, "translationX", 230f, -230f);
                animation.setDuration(2000);
                animation.setRepeatCount(10);
                animation.setRepeatMode(ValueAnimator.REVERSE);
                animation.start();

//                  ObjectAnimator animator = ObjectAnimator.ofFloat(Animation.this,R.anim.move);
//                  imgView.startAnimation(animator);

//                android.view.animation.Animation animation = AnimationUtils.loadAnimation(Animation.this, R.anim.move);
//                imgView.startAnimation(animation);
            }
        });


    }





}
