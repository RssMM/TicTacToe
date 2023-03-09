package com.example.tictactoe;

import java.util.Objects;

public class History {
    private String duration;
    private String status;
    private String id;

    public History(String duration, String status, String id) {
        this.duration = duration;
        this.status = status;
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "movie='" + duration + '\'' +
                ", director='" + status + '\'' +
                ", year=" + id +
                '}';
    }

}