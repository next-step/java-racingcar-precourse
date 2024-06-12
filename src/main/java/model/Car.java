package model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove() {
        int randNum = (int)(Math.random() * 10);
        if (randNum >= 4) {
            position++;
        }
    }
}
