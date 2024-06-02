package model;

public class Car {
    private final String name;
    private int distance;
    private String progressLine;

    public Car (String name) {
        this.name = name;
        this.distance = 0;
        this.progressLine = "";
    }

    public void moveForward() {
        this.distance++;
        this.progressLine += "-";
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getProgressLine() {
        return progressLine;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
