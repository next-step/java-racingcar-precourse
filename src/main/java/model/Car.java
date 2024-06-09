package model;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public void moveFoward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
