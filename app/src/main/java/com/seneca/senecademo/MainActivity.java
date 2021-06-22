package com.seneca.senecademo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView splash_imageView=(ImageView)findViewById(R.id.splash_imageView);
        Animation set = AnimationUtils.loadAnimation(this,
                R.anim.splash_screen_animation);
        splash_imageView.setAnimation(set);
        set.start();

        Thread checkForData = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(LoginActivity.flag) {
                        startActivity(new Intent(MainActivity.this,
                                Mainactivity2.class));
                    }
                    else
                    {
                        startActivity(new Intent(MainActivity.this,
                                LoginActivity.class));
                    }
                    finish();
                }
            }
        };
        checkForData.start();


    }


}