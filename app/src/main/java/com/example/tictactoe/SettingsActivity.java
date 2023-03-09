package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onBackPressed();

            }
        });

        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
            }
        });



    }
}