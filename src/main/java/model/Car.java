package model;

public class Car {
    private static final int MOVE_FORWARD_STANDARD = 4;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(int number) {
        if (number >= MOVE_FORWARD_STANDARD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
