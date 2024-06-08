package model;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void moveCar() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }
}
