package com.example.lovingtonapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class GetStartedActivity extends AppCompatActivity {
        Button btnLogin, btnRegister;
        Animation ttb, btt;
        ImageView logo;
        TextView title, desc;

        Button tombol;
        String channelnotif = "channelku" ;
        String channelid = "default" ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_getstarted);

            tombol = (Button) findViewById(R.id.buttonNotification);
            tombol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notif();

                }
            });

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
        private void notif() {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(GetStartedActivity. this, channelid )
                    .setSmallIcon(R.drawable.group)
                    .setContentTitle( "Your order's confirmed" )
                    .setContentText( "Check your Whatsapp, we will texting soon!" );
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context. NOTIFICATION_SERVICE ) ;
            if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
                int importance = NotificationManager. IMPORTANCE_HIGH ;
                NotificationChannel notificationChannel = new
                        NotificationChannel( channelnotif , "contoh channel" , importance) ;
                notificationChannel.enableLights( true ) ;
                notificationChannel.setLightColor(Color. RED ) ;
                mBuilder.setChannelId( channelnotif ) ;
                assert mNotificationManager != null;
                mNotificationManager.createNotificationChannel(notificationChannel) ;
            }
            assert mNotificationManager != null;
            mNotificationManager.notify(( int ) System. currentTimeMillis (), mBuilder.build()) ;
        }
}