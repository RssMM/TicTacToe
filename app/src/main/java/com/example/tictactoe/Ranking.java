package com.example.tictactoe;

import java.util.Objects;

public class Ranking {
    private String playername;
    private String winrate;
    private int match;

    public Ranking(String playername, String winrate, int match) {
        this.playername = playername;
        this.winrate = winrate;
        this.match = match;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getWinrate() {
        return winrate;
    }

    public void setWinrate(String winrate) {
        this.winrate = winrate;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranking film = (Ranking) o;
        return match == film.match && Objects.equals(playername, film.playername) && Objects.equals(winrate, film.winrate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playername, winrate, match);
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "movie='" + playername + '\'' +
                ", director='" + winrate + '\'' +
                ", year=" + match +
                '}';
    }

}
