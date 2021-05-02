package com.tjnam.racingcargame;

public class RacingTime {
    private int remained;

    public RacingTime(int time){
        this.remained = time;
    }

    public void use(){
        this.remained--;
    }

    public int getRemained(){
        return this.remained;
    }
}
