package model;

public class Car {

    private final String carName;
    private int position = 0;

    public Car(String name) {
        this.carName = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position += 1;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
