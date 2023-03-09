package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SinglePlayerOptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleplayer);

        findViewById(R.id.start_singleplayer).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText name = (EditText) findViewById(R.id.playerOne);

                Intent intent = new Intent(SinglePlayerOptionActivity.this, GameActivity.class);
                intent.putExtra("name", name.getText().toString());

                if(!name.getText().toString().isEmpty()){
                    startActivity(new Intent(SinglePlayerOptionActivity.this,  GameActivity.class));
                }
            }
        });

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onBackPressed();

            }
        });

        findViewById(R.id.profile).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SinglePlayerOptionActivity.this, ProfileActivity.class));
            }
        });


        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SinglePlayerOptionActivity.this, SettingsActivity.class));
            }
        });

    }
}