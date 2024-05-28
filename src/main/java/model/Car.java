package model;

public class Car {

    private String name;
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

    public void updateCount(int count) {
        this.count = count;
    }

}
