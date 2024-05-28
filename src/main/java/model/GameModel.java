package model;

import java.util.ArrayList;

public class GameModel {

    private ArrayList<Car> cars;
    private int carsCount;
    private int repeatCount;

    public GameModel() {
        cars = new ArrayList<>();
        carsCount = 0;
        repeatCount = 0;
    }

    public int getCarsCount() {
        return carsCount;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Car getCar(int idx) {
        return cars.get(idx);
    }

    public void addCar(Car car) {
        cars.add(car);
        ++carsCount;
    }
}
