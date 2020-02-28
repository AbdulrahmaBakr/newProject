package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity  extends AppCompatActivity  {

    TextView textView1;
    Button btngo;
    ImageView imageview1 ;
    Animation atg,text,btn ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textview1);
        btngo = findViewById(R.id.btngo);
        imageview1=findViewById(R.id.imageview1);


        //load animation
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        text =AnimationUtils.loadAnimation(this,R.anim.text);
        btn = AnimationUtils.loadAnimation(this,R.anim.btn);

        // passing animation
        imageview1.startAnimation(atg);
        textView1.startAnimation(text);
        btngo.startAnimation(btn);



        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this,stopwatchac.class);
                startActivity(go);

            }
        });
    }
}
