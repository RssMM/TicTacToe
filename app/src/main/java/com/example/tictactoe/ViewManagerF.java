package com.example.tictactoe;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewManagerF extends RecyclerView.ViewHolder {
    private TextView friend, status;

    ViewManagerF(@NonNull View itemView) {
        super(itemView);
        friend = itemView.findViewById(R.id.frineds_name);
        status = itemView.findViewById(R.id.friend_status);

    }

    TextView getFriend() {
        return friend;
    }

    TextView getStatus() {
        return status;
    }

}