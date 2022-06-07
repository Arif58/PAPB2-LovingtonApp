package com.example.lovingtonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity {
        Button btnLogin, btnRegister;
        Animation ttb, btt;
        ImageView logo;
        TextView title, desc;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_getstarted);

            ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
            btt = AnimationUtils.loadAnimation(this, R.anim.btt);

            btnLogin = findViewById(R.id.btnLogin);
            btnRegister = findViewById(R.id.btnRegister);

            logo = findViewById(R.id.imageView);
            title = findViewById(R.id.title);
            desc = findViewById(R.id.description);

            logo.startAnimation(ttb);
            title.startAnimation(ttb);
            desc.startAnimation(ttb);
            btnLogin.startAnimation(btt);
            btnRegister.startAnimation(btt);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent gotologin = new Intent(GetStartedActivity.this, LoginActivity.class);
                    startActivity(gotologin);
                }
            });

            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent gotoregister = new Intent(GetStartedActivity.this, RegisterActivity.class);
                    startActivity(gotoregister);
                }
            });
        }
    }

