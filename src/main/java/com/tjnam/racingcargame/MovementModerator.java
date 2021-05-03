package com.tjnam.racingcargame;

public class MovementModerator {
    private final static RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

    boolean canBeMove(){
        if (randomValueGenerator.getValue() > 3) {
            return true;
        }
        return false;
    }
}
