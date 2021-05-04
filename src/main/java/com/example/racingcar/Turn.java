package com.example.racingcar;

public class Turn {
    private int currentTurn;
    private final int maxTurn;
    public Turn(int maxTurn) {
        if (maxTurn < 1) {
            throw new IllegalArgumentException();
        }
        this.currentTurn = 0;
        this.maxTurn = maxTurn;
    }

    public boolean next() {
        currentTurn++;
        return currentTurn <= maxTurn;
    }
}
