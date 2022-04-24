package racingcar.model;

import java.util.List;

public class Game {
    private int numberOfExecutions;
    private CarList carList;

    public Game(String numberOfExecutions) {
        checkInputParameter(numberOfExecutions);
        this.numberOfExecutions = Integer.valueOf(numberOfExecutions);
    }

    public Game(String numberOfExecutions, List<Car> carList) {
        checkInputParameter(numberOfExecutions);
        this.numberOfExecutions = Integer.valueOf(numberOfExecutions);
        this.carList = new CarList(carList);
    }

    private void checkInputParameter(String str) {
        boolean isNotNumeric = !str.chars().allMatch(Character::isDigit);
        if (isNotNumeric) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfExecutions() {
        return numberOfExecutions;
    }

    public void setCarList(List<Car> carList) {
        this.carList = new CarList(carList);
    }

    public CarList getCarList() {
        return carList;
    }
}
