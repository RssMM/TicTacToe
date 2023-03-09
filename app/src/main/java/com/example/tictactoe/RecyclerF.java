package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerF extends RecyclerView.Adapter<ViewManagerF> {
    private List<Friends> friends;


    public RecyclerF(List<Friends> history) {
        this.friends = history;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public void addHistory(Friends friends) {
        this.friends.add(friends);
        this.notifyItemInserted(this.friends.size() - 1);
    }

    @NonNull
    @Override
    public ViewManagerF onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_friends, parent, false);
        final ViewManagerF viewHolder = new ViewManagerF(vista);
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewManagerF holder, @SuppressLint("RecyclerView") int position) {
        Friends friend = this.friends.get(position);
        String state = friend.isStatus() ? "ONLINE" : "OFFLINE";
        holder.getStatus().setText(state);
        holder.getFriend().setText(friend.getFriends());

    }

    @Override
    public int getItemCount() {
        return this.friends.size();
    }

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void getPosition(int pos);
    }
}

