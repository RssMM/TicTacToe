package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class GameActivity extends Activity {

    int[] viewArray = new int[]{
            R.id.imageButton,
            R.id.imageButton1,
            R.id.imageButton2,
            R.id.imageButton3,
            R.id.imageButton4,
            R.id.imageButton5,
            R.id.imageButton6,
            R.id.imageButton7,
            R.id.imageButton8

    };
    int size = viewArray.length;

    final boolean[] state = {true};

    boolean[] clicked  = new boolean[9];

    final int[] clickCount = {0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_table);

        findViewById(R.id.profile).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(GameActivity.this, ProfileActivity.class));
            }
        });

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(GameActivity.this, QuitActivity.class));
            }
        });

        for(int i = 0; i < size; i++){
            clicked[i] = false;
        }

        for(int i = 0; i < size; i++) {
            ImageButton imgbtn = (ImageButton) findViewById(viewArray[i]);
            if(imgbtn != null) {
                int finalI = i +  1;
                int finalI1 = i;
                imgbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!clicked[finalI1]){
                            clicked[finalI1] = true;
                            if(state[0]){
                                clickCount[0]++;
                                imgbtn.setImageResource(R.drawable.x);
                                state[0] = false;

                               // won(finalI1, R.drawable.x);
                            }else{
                                clickCount[0]++;
                                imgbtn.setImageResource(R.drawable.o);
                                state[0] = true;
                                //won(finalI1, R.drawable.o);
                            }

                        }

                        reset(clickCount[0], viewArray);

                    }
                });
            }
        }
    }

    public void reset(int count , int[] arr){
        if(count >= 9){
            Toast.makeText(getApplicationContext(), "You Won! PLAYER1", Toast.LENGTH_SHORT).show();
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(count >= 9){
                    for(int i = 0; i < arr.length ; i++){
                        ((ImageButton) findViewById(arr[i])).setImageResource(0);

                    }
                    for(int i = 0; i < size; i++){
                        clicked[i] = false;
                    }
                    clickCount[0] = 0;
                }
            }
        }, 3000);

    }

    public void won(int f, int drawable){







        int[][] winningpos = new int[][]{
                {1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,0 ,0 ,1 ,1 ,1 ,0 ,0 ,0},
                {0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1},
                {1 ,0 ,0 ,1 ,0 ,0 ,1 ,0 ,0},
                {0 ,1 ,0 ,0 ,1 ,0 ,0 ,1 ,0},
                {0 ,0 ,1 ,0 ,0 ,1 ,0 ,0 ,1},
                {1 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,1},
                {0 ,0 ,1 ,0 ,1 ,0 ,1 ,0 ,0}
        };

        int[][] check = new int[][]{
                {0,3,6},
                {0,4},
                {0,5,7},
                {1,3},
                {1,4,6,7},
                {1,5},
                {2,3,7},
                {2,4},
                {2,6,5}
        };
        Drawable myDrawable = ContextCompat.getDrawable(this,drawable);
        for(int j = 0; j < size; j++){
            ImageButton temp =  findViewById(viewArray[j]);
            for(int k = 0; k < winningpos.length; k++){
                for(int i = 0; i < winningpos[k].length ; i++){
                    if(temp.getDrawable() != null) {
                        if(winningpos[k][j] == j){
                            System.out.println("eeeeeee");
                        }

                    }
                }
            }
        }
        /*for(int j = 0; j < size; j++){
                ImageButton temp =  findViewById(viewArray[f]);

                if(temp.getDrawable() != null){
                    Bitmap imageBtm = ((BitmapDrawable)temp.getDrawable()).getBitmap();
                    Bitmap appleBtm = ((BitmapDrawable) myDrawable).getBitmap();
                    System.out.println(temp.getDrawable());


                    for(int i = 0 ; i < check[f].length ; i++) {
                        int match = 0;
                        for(int k = 0; k < winningpos[check[f][i]].length; k++){
                            if((imageBtm.sameAs(appleBtm) ? 1 : 0) == winningpos[check[f][i]][k]){
                                if(winningpos[check[f][i]][k] == winningpos[f][k]){
                                    match++;
                                }

                            }

                        }

                        System.out.println(match);

                    }
                }

            }*/
    }


}