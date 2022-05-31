package com.example.lovingtonapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    Animation app_splash,bottom_totop;
    ImageView app_logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        app_splash= AnimationUtils.loadAnimation(this,R.anim.app_splash);
        bottom_totop=AnimationUtils.loadAnimation(this,R.anim.bottom_totop);
        app_logo=findViewById(R.id.app_logo);

        app_logo.startAnimation(app_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //merubah activity
                Intent gotomain = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(gotomain);
                finish();
            }
        }, 2000);
    }
}
