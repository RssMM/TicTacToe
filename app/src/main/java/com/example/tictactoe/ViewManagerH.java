package com.example.tictactoe;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewManagerH extends RecyclerView.ViewHolder {
    private TextView id, status, duration;


    ViewManagerH(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.playername1);
        status = itemView.findViewById(R.id.status);
        duration = itemView.findViewById(R.id.duration);
    }

    TextView getId() {return id;}

    TextView getStatus() {return status;}

    TextView getDuration() {return duration;}
}