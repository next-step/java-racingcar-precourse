package model;

public class Car {
    private String name;
    private int curPosition;

    public Car() {}
    public Car(String name) {
        this.name = name;
        curPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurPosition() {
        return curPosition;
    }

    public void moveCurPosition() {
        curPosition++;
    }
}
