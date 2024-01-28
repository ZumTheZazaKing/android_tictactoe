package com.zumthezazaking.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Ingame extends AppCompatActivity{

    boolean gameActive = true;
    int currentPlayer = 0; // 0:X, 1:O
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int counter = 0;
    TextView turnText;

    int[][] winConditions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };
    Button doneBtn;

    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImg = Integer.parseInt(img.getTag().toString());
        turnText = (TextView) findViewById(R.id.turnText);

        if(gameState[tappedImg] == 2 && gameActive) {
            counter++;
            if(counter>=9)gameActive=false;

            gameState[tappedImg] = currentPlayer;

            Animation popupAnimation = AnimationUtils.loadAnimation(this,R.anim.pop_up);
            if(currentPlayer == 0){
                img.setImageResource(R.drawable.x);
                currentPlayer = 1;
                turnText.setText("O's Turn");
            }else{
                img.setImageResource(R.drawable.o);
                currentPlayer = 0;
                turnText.setText("X's Turn");
            }
            img.startAnimation(popupAnimation);

            int flag = 0;
            if(counter > 4){
                for(int[] winCondition : winConditions){
                    if(gameState[winCondition[0]] == gameState[winCondition[1]] &&
                            gameState[winCondition[1]] == gameState[winCondition[2]] &&
                            gameState[winCondition[2]] != 2
                    ){
                        flag = 1;
                        gameActive = false;
                        if(gameState[winCondition[0]] == 0){
                            turnText.setText("X has Won!");
                        }else{
                            turnText.setText("O has Won!");
                        }
                    }
                }
                if(counter>=9 && flag == 0){
                    gameActive = false;
                    turnText.setText("It's a tie");
                }
            }

            if(!gameActive){
                doneBtn = (Button) findViewById(R.id.doneBtn);
                doneBtn.setVisibility(View.VISIBLE);
                doneBtn.startAnimation(popupAnimation);
            }
        }

    }

    public void goToMain(View view){
        Intent intent = new Intent(Ingame.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingame);

        turnText = (TextView) findViewById(R.id.turnText);
        turnText.setText("X's Turn");
    }
}