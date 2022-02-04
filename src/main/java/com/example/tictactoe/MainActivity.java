package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] arr = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int currentplayer =0;
    //0 denotes x
    //1 denotes O

    int[][] winningposition = { {0, 1, 2} , {3, 4, 5} , {6, 7, 8} ,
                                {0, 3, 6} , {1, 4, 7} , {2, 5, 8} ,
                                {0, 4, 8} , {2, 4, 6}};
    boolean gameactive = true;

    public void playerTap(View v){
        if(!gameactive){
            resetGame(v);
            return;
        }
        ImageView img = (ImageView) v;
        int position = Integer.parseInt(img.getTag().toString());
        if(arr[position] == 2){
            arr[position] = currentplayer;
            if(currentplayer == 0){
                img.setImageResource(R.drawable.x);
                currentplayer = 1;
            }
            else{
                img.setImageResource(R.drawable.o);
                currentplayer = 0;
            }
        }
        for(int[] winning : winningposition){
            if(arr[winning[0]] == arr[winning[1]] && arr[winning[1]] == arr[winning[2]] && arr[winning[0]] != 2){
                if(arr[winning[0]] == 1){
                    Toast.makeText(getApplicationContext(), "Player 2 is the winnner", Toast.LENGTH_SHORT).show();
                    gameactive = false;
                }
                else{
                    Toast.makeText(getApplicationContext(), "Player 1 is the winnner", Toast.LENGTH_SHORT).show();
                    gameactive = false;
                }
            }
        }
    }

    public void resetGame(View view){  //function to reset the game
        currentplayer = 0;
        for(int i=0 ; i<9 ; i++){
            arr[i] = 2;
        }
        gameactive = true;
        ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);   //setting all the imaeges to zero
        ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView19)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView20)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}