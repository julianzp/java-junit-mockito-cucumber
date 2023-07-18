package org.example;

public class ScoreBoard {

    //initialize variables
    private Integer ties;
    private Integer wins;
    private Integer losses;

    public ScoreBoard(){
        ties = 0;
        wins = 0;
        losses = 0;
    }

    public Integer getTies() {
        return ties;
    }

    public void incrementTies(){
        ties++;
    }

    public Integer getWins() {
        return wins;
    }

    public void incrementWins(){
        wins++;
    }

    public Integer getLosses() {
        return losses;
    }

    public void incrementLosses(){
        losses++;
    }

}
