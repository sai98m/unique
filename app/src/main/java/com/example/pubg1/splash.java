package com.example.pubg1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler hd = new Handler();
        hd.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i =new Intent(splash.this,MainActivity.class);
                startActivity(i);
            }
        },3000);
    }
}