package com.game.racingcar.car.input;

public class Position {
    private int x = 1;
    private int y = 0;

    public void moveRight() {
        this.x++;
    }

    public String getPositionGraphString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.x; i++) {
            sb.append("-");
        }

        for (int j = 0; j < this.y; j++) {
            sb.append("|");
        }

        return sb.toString();
    }

    public int getX() {
        return x;
    }
}
