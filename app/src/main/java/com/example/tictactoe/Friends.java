package com.example.tictactoe;

public class Friends {
    private String friends;
    private boolean status;

    public Friends(String friends, boolean status) {
        this.friends = friends;
        this.status = status;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
