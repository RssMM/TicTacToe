package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SinglePlayerOptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleplayer);

        EditText player1EditText = findViewById(R.id.player1);


        findViewById(R.id.start_singleplayer).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SinglePlayerOptionActivity.this,  GameActivity.class);
                intent.putExtra("player1_name", "AI");
                intent.putExtra("player2_name", player1EditText.getText().toString());


                if(!player1EditText.getText().toString().isEmpty()){
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Fill the player names", Toast.LENGTH_SHORT).show();
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