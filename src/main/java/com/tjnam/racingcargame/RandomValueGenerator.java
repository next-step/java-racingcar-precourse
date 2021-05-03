package com.tjnam.racingcargame;

public class RandomValueGenerator {
    public int getValue(){
        int pick = (((int) (Math.random() * 10)) % 9) + 1;
        return pick;
    }
}
