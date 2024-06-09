package entity;

public class Car {
    private String name;
    private int distance;
    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }
    public void move() {
        this.distance++;
    }
    public String getName() {
        return this.name;
    }
    public int getDistance() {
        return this.distance;
    }
    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
