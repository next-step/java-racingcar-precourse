package model;

public class Car {

    private final String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void move() {
        this.count += 1;
    }

}
