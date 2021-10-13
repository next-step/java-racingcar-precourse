package racinggame.model;

import racinggame.enums.RANDOM_MOVE_RESULT;
import racinggame.vo.Car;
import racinggame.vo.CarLocation;
import racinggame.vo.Cars;

public class WinnerPicker {
    private Cars winnerCars;
    private CarLocation currentMaxLocation;

    public WinnerPicker() {
        this.winnerCars = new Cars();
        this.currentMaxLocation = new CarLocation();
    }

    public void standBy(Cars cars) {
        this.winnerCars.add(cars);
    }

    public Cars getWinnerCars() {
        return this.winnerCars;
    }

    public boolean tryPick(Car car, RANDOM_MOVE_RESULT moveResult) {
        if (moveResult != RANDOM_MOVE_RESULT.FORWARD) {
            return false;
        }

        return tryPickInternal(car);
    }

    private boolean tryPickInternal(Car car) {
        if (this.currentMaxLocation.isGreaterThan(car.getLocation())) {
            return false;
        }

        if (this.currentMaxLocation.equals(car.getLocation())) {
            this.winnerCars.addOnlyOnce(car);
            return true;
        }

        refreshWinnerCars(car);
        return true;
    }

    private void refreshWinnerCars(Car car) {
        this.winnerCars.clear();
        this.winnerCars.add(car);
        this.currentMaxLocation = new CarLocation(car.getLocation());
    }
}