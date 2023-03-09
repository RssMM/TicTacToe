package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycler extends RecyclerView.Adapter<ViewManager> {
    private List<Ranking> rankings;


    public Recycler(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }

    public void addFilm(Ranking ranking) {
        this.rankings.add(ranking);
        this.notifyItemInserted(this.rankings.size() - 1);
    }

    public void removeRanking(int pos) {
        if (pos < 0 || pos >= this.getItemCount()) return;
        this.rankings.remove(pos);
        this.notifyItemRemoved(pos);
    }

    public void editRanking(Ranking ranking, int pos){
        this.rankings.get(pos).setWinrate(ranking.getWinrate());
        this.rankings.get(pos).setMatch(ranking.getMatch());
        this.rankings.get(pos).setPlayername(ranking.getPlayername());
        this.notifyItemChanged(pos);
    }

    @NonNull
    @Override
    public ViewManager onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ranking, parent, false);
        final ViewManager viewHolder = new ViewManager(vista);
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return viewHolder;
    }

    public static int i = 1;
    @Override
    public void onBindViewHolder(@NonNull ViewManager holder, @SuppressLint("RecyclerView") int position) {
        Ranking ranking = this.rankings.get(position);
        holder.getPlayername().setText(ranking.getPlayername());
        holder.getWinrate().setText(String.valueOf("WinRate\n" + ranking.getWinrate()));
        holder.getMatch().setText(String.valueOf("Match \n" + ranking.getMatch()));
        holder.getRank().setText(String.valueOf(i) + "#");
        i++;
    }

    @Override
    public int getItemCount() {
        return this.rankings.size();
    }

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void getPosition(int pos);
    }
}
