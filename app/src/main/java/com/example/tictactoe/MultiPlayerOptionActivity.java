package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MultiPlayerOptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer);

        findViewById(R.id.start_singleplayer).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MultiPlayerOptionActivity.this,  GameActivity.class));
            }
        });

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onBackPressed();

            }
        });

        findViewById(R.id.profile).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MultiPlayerOptionActivity.this, ProfileActivity.class));
            }
        });

        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MultiPlayerOptionActivity.this, SettingsActivity.class));
            }
        });

    }
}