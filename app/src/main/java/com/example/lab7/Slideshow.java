package com.example.lab7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Slideshow extends AppCompatActivity {

    Button btnAll, btnDoraemon, btnNobita;

    ImageView imgView2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow);
        
        btnAll = (Button)findViewById(R.id.btnAll);
        btnDoraemon = (Button)findViewById(R.id.btnDoraemon);
        btnNobita = (Button)findViewById(R.id.btnNobita);
        imgView2 = (ImageView) findViewById(R.id.imgView2);
        
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("all");
            }
        });
        
        btnDoraemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("doraremon");
            }
        });
        
        btnNobita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("nobita");
            }
        });
    }

    private void showImage(String img) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(imgView2, "translationX", 0f, 400f);
        anim.setDuration(1000);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(imgView2, "alpha",1f,0f);
        anim1.setDuration(1000);

        //show Image
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(imgView2, "translationX", -400f, 0f);
        anim2.setDuration(1000);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(imgView2, "alpha", 0f, 1f);
        anim3.setDuration(1000);


        AnimatorSet ans = new AnimatorSet();
        ans.play(anim2).with(anim3).after(anim).after(anim1);
        ans.start();

        final String imgName = img;
        anim2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (imgName == "all"){
                    imgView2.setImageResource(R.drawable.all);
                }
                if (imgName == "nobita"){
                    imgView2.setImageResource(R.drawable.nobita);
                }
                if (imgName == "doraremon"){
                    imgView2.setImageResource(R.drawable.doraemon);
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {



            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
