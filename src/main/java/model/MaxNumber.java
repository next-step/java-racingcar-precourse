package model;

import java.util.List;

public class MaxNumber {

    private int maxNumber;

    public MaxNumber(int initNumber) {
        this.maxNumber = initNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void updateMaxNumber(List<Car> cars) {
        for (Car car : cars) {
            maxNumber = Math.max(maxNumber, car.getCount());
        }
    }

}
