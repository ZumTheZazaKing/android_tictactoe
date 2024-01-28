package com.zumthezazaking.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation sideToSideAnimation = AnimationUtils.loadAnimation(this,R.anim.side_to_side);

        TextView game_title = (TextView) findViewById(R.id.game_title);
        Button play_button = (Button) findViewById(R.id.playBtn);

        play_button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Ingame.class);
            startActivity(intent);
            finish();
        });

        game_title.startAnimation(sideToSideAnimation);
    }
}