package racinggame.model;

public class Car {

    private String carName;
    private int nowPosition;

    public Car(String carName, int nowPosition) {
        this.carName = carName;
        this.nowPosition = nowPosition;
    }

    public String confirmCarName() {
        return this.carName;
    }

    public int confirmNowPosition() {
        return this.nowPosition;
    }


}
