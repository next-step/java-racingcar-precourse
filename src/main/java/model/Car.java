package model;

public class Car {

    private String name;
    private int pos;

    private Car() {
    }

    public Car(String name) {
        this.name = name;
        this.pos = 0;
    }

    public Car(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void moveForward() {
        ++pos;
    }
}
