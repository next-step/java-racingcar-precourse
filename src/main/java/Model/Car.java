package Model;

import java.util.Random;

public class Car {
    private String carName;
    private int positon;

    public Car(String carName, int positon) {
        this.carName = carName;
        this.positon = positon;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPositon() {
        return positon;
    }

    public void setPositon(int positon) {
        this.positon = positon;
    }

    public void move() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            positon++;
        }
    }
}
