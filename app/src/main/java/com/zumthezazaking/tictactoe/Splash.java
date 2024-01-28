package com.zumthezazaking.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Animation splashAnimation = AnimationUtils.loadAnimation(this,R.anim.splash);

        TextView splash_text = (TextView) findViewById(R.id.splash_text);
        splash_text.startAnimation(splashAnimation);

        new android.os.Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash.this, MainActivity.class);
            startActivity(intent);
            finish();
        },3000);
    }
}