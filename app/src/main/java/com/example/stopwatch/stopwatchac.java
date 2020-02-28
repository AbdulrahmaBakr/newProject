package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class stopwatchac extends AppCompatActivity {

            Button btnstart,btnend ;
            ImageView imageview3 ,imageview2;
            Animation run,image2,image3,btn2  ;
            Chronometer timer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatchac);
        imageview2 = findViewById(R.id.imageview2);
        btnstart = findViewById(R.id.btnstart);
        imageview3 = findViewById(R.id.imageview3);
        btnend = findViewById(R.id.btnend);
        timer = findViewById(R.id.timer);

        btnend.setAlpha(0);
        //load animation
        run = AnimationUtils.loadAnimation(this,R.anim.run);
        image2 = AnimationUtils.loadAnimation(this,R.anim.image2);
        image3 = AnimationUtils.loadAnimation(this,R.anim.image3);
        btn2= AnimationUtils.loadAnimation(this,R.anim.btn2);

        imageview2.startAnimation(image2);
        imageview3.startAnimation(image3);
        btnstart.startAnimation(btn2);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pass animation
                imageview3.startAnimation(run);


                btnend.animate().alpha(1).translationY(-20).setDuration(300).start();
               //btnstart.animate().alpha(0).setDuration(300).start();

                //start timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();

            }
        });

        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageview3.clearAnimation();
                timer.stop();
            }
        });

    }
}
