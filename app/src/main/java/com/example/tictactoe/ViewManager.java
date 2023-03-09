package com.example.tictactoe;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewManager extends RecyclerView.ViewHolder {
    private TextView playername, winrate, match, rank;


    ViewManager(@NonNull View itemView) {
        super(itemView);
        playername = itemView.findViewById(R.id.playername);
        winrate = itemView.findViewById(R.id.winrate);
        match = itemView.findViewById(R.id.match);
        rank = itemView.findViewById(R.id.rank);
    }

    TextView getPlayername() {
        return playername;
    }

    TextView getWinrate() {
        return winrate;
    }

    TextView getMatch(){
        return match;
    }

    TextView getRank() {
        return rank;
    }

}