package model;

import java.util.Random;

public class Car {

    private String name;
    private int distance = 0;
    private boolean winner = false;

    public Car(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDistance(int distance) {
        this.distance = distance;
    }

    public void setWinner(boolean isWin) {
        this.winner = isWin;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public boolean isWinner() {
        return this.winner;
    }

    public void moveForward() {
        Random random = new Random();

        int distance = random.nextInt(0, 10);

        if (distance > 3) {
            setDistance(this.distance + 1);
        }
    }

}
