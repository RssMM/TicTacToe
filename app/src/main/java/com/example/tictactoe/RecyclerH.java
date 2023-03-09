package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerH extends RecyclerView.Adapter<ViewManagerH> {
    private List<History> history;


    public RecyclerH(List<History> history) {
        this.history = history;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public void addHistory(History history) {
        this.history.add(history);
        this.notifyItemInserted(this.history.size() - 1);
    }

    public void removeHistory(int pos) {
        if (pos < 0 || pos >= this.getItemCount()) return;
        this.history.remove(pos);
        this.notifyItemRemoved(pos);
    }

    public void editHistory(History history, int pos){
        this.history.get(pos).setStatus(history.getStatus());
        this.history.get(pos).setId(history.getId());
        this.history.get(pos).setDuration(history.getDuration());
        this.notifyItemChanged(pos);
    }

    @NonNull
    @Override
    public ViewManagerH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_history, parent, false);
        final ViewManagerH viewHolder = new ViewManagerH(vista);
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewManagerH holder, @SuppressLint("RecyclerView") int position) {
        History history = this.history.get(position);
        holder.getStatus().setText("Status\n" + String.valueOf(history.getStatus()));

        holder.getDuration().setText("Duration\n" + String.valueOf(history.getDuration()));
        holder.getId().setText(String.valueOf(history.getId()));

    }

    @Override
    public int getItemCount() {
        return this.history.size();
    }

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void getPosition(int pos);
    }
}
