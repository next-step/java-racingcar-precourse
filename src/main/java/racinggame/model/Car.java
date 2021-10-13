package racinggame.model;

public class Car {

    private String carName;
    private int nowPosition = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String confirmCarName() {
        return this.carName;
    }

    public int confirmNowPosition() {
        return this.nowPosition;
    }

    public void moveForward() {
        this.nowPosition += 1;
    }

    public void stayHere() {
        this.nowPosition += 0;
    }
}
