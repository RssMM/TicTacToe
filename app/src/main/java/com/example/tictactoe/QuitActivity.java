package com.example.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quit);

        findViewById(R.id.history_button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onBackPressed();
            }
        });

        findViewById(R.id.select_yes).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(QuitActivity.this, MenuActivity.class));
            }
        });

    }

}