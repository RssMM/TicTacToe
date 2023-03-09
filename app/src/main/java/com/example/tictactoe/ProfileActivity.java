package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfileActivity extends FragmentActivity {

    private Fragments fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        List<Friends> friends = new ArrayList<>();
        friends.add(new Friends("werwtv", false));
        friends.add(new Friends("rissqy2", true));
        friends.add(new Friends("sudoking", false));
        friends.add(new Friends("sogek", false));
        friends.add(new Friends("batban", true));
        friends.add(new Friends("owlseek", true));

        friends.add(new Friends("sudoking", false));
        friends.add(new Friends("sogek", false));
        friends.add(new Friends("batban", true));
        friends.add(new Friends("owlseek", true));

        List<Friends> friendsFilter = new ArrayList<>();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Fragments(R.layout.history))
                .commit();

        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ProfileActivity.this, SettingsActivity.class));
            }
        });

        findViewById(R.id.button_back).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               onBackPressed();
            }
        });

        findViewById(R.id.ranking_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Fragments(R.layout.ranking))
                        .commit();
            }
        });

        findViewById(R.id.history_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Fragments(R.layout.history))
                        .commit();
            }
        });

        findViewById(R.id.friends_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopUpFragment fragment = new PopUpFragment(friends);
                fragment.show(getSupportFragmentManager(), "dialog");

            }
        });







    }
}