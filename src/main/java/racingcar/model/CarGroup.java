package racingcar.model;

import racingcar.model.Car;

import java.util.*;

public class CarGroup {

    private ArrayList<Car> cars;

    public CarGroup() {
        this.cars = new ArrayList<Car>();
    }

    public CarGroup(ArrayList<Car> cars) {
        this.cars = new ArrayList<Car>();
        this.cars.addAll(cars);
    }

    public ArrayList<Car> getCars() {
        return this.cars;
    }

    public ArrayList<Car> getWinnerGroups() {
        ArrayList<Car> winners = new ArrayList<>();
        cars.sort(Comparator.reverseOrder());
        int winnerPosition = cars.get(0).getPosition();
        for (Car car : cars) {
            addWinner(winners, winnerPosition, car);
        }
        return winners;
    }

    private void addWinner(ArrayList<Car> winners, int winnerPosition, Car thisCar) {
        if (winnerPosition == thisCar.getPosition())
            winners.add(thisCar);
    }

    public boolean addCar(String carName) {
        try {
            cars.add(new Car(carName));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return false;
        }
        return true;
    }

    public void move(int moveCount) {
        for (Car car : this.getCars()) {
            car.move(moveCount);
        }
    }
}
