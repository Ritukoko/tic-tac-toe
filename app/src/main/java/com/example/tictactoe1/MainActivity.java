package com.example.tictactoe1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive=true;
    int actplayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2 };
    int [][] winpos={{0,1,2},{3,4,5},{6,7,8,},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};

    public void tap(View view){
        ImageView img=(ImageView) view;
        int tapimg=Integer.parseInt(img.getTag().toString());
        if(!gameactive)
            gamereset();
        if(gamestate[tapimg]==2 && gameactive) {
            gamestate[tapimg] = actplayer;
            img.setTranslationY(-1000f);
            if (actplayer == 0) {
                img.setImageResource(R.drawable.o);
                actplayer = 1;
                TextView chance= findViewById(R.id.chance);
                chance.setText(("X's turn"));
                                }
            else {
                actplayer = 0;
                img.setImageResource(R.drawable.x);
                TextView chance=findViewById(R.id.chance);
                chance.setText("O's turn");
            }

            img.animate().translationYBy(1000f);
        }
        for(int [] wp:winpos)
        {
            if(gamestate[wp[0]]==gamestate[wp[1]]&&
                gamestate[wp[1]]==gamestate[wp[2]]&&
                gamestate[wp[0]]!=2)

            {
                if(gamestate[wp[0]]==0)
                {
                    TextView chance=findViewById(R.id.chance);
                    chance.setText("player 1(with o) has won");
                    gameactive=false;
                }
                else {
                    TextView chance=findViewById(R.id.chance);
                    chance.setText("player 2 (with X) has won");
                    gameactive=false;
                }
            }
        }
    }

    public void gamereset()
    {   Character val;
        gameactive=true;
        actplayer=0;
        for(int i=0;i<gamestate.length;i++)
            gamestate[i]=2;

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }
    public void reset(View Button)
    {
        gamereset();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}