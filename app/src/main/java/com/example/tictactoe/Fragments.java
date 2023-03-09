package com.example.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragments extends Fragment {
    int layout;
    public Fragments(int layout){
        this.layout  = layout;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);
        switch (layout){
            case R.layout.ranking:
                RecyclerView recycler = view.findViewById(R.id.recycler);
                List<Ranking> rankings = new ArrayList<>();
                Recycler adapter = new Recycler(rankings);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                recycler.setLayoutManager(linearLayoutManager);

                rankings.add(new Ranking("werwtv", "87", 203));
                rankings.add(new Ranking("rissqy2", "76%", 234));
                rankings.add(new Ranking("sudoking", "73%", 667));
                rankings.add(new Ranking("sogek", "72%", 100));
                rankings.add(new Ranking("batban", "65%", 245));
                rankings.add(new Ranking("owlseek", "53%", 377));
                rankings.add(new Ranking("averagepl", "50%", 405));
                rankings.add(new Ranking("sudoking", "73%", 667));
                rankings.add(new Ranking("sogek", "72%", 100));
                rankings.add(new Ranking("batban", "65%", 245));
                rankings.add(new Ranking("owlseek", "53%", 377));
                rankings.add(new Ranking("averagepl", "50%", 405));


                recycler.setAdapter(adapter);
                break;
            case R.layout.history:
                RecyclerView recycler1 = view.findViewById(R.id.recycler1);
                List<History> history = new ArrayList<>();
                RecyclerH adapter1 = new RecyclerH(history);
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
                recycler1.setLayoutManager(linearLayoutManager1);

                history.add(new History("0:1:10", "Won", "Mrtictactoe"));
                history.add(new History("0:0:21", "Won", "bonemeal"));
                history.add(new History("0:0:54", "Lost", "firbyRf"));
                history.add(new History("0:0:25", "Won", "oneway456"));
                history.add(new History("0:0:30", "Lost", "PlayerName1"));
                history.add(new History("0:1:10", "Won", "Mrtictactoe"));
                history.add(new History("0:0:21", "Won", "bonemeal"));
                history.add(new History("0:0:54", "Lost", "firbyRf"));
                history.add(new History("0:0:25", "Won", "oneway456"));
                history.add(new History("0:0:30", "Lost", "PlayerName1"));

                recycler1.setAdapter(adapter1);
                break;
            default:
        }

        return view;
    }
}
