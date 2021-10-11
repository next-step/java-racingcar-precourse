package racinggame.domain;

import racinggame.view.RacingCarOutput;

import java.util.List;

public class Cars {
    private static final int START_VALUE = 0;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public String race(AttemptCount attepmtCount) {
        for (int i = START_VALUE; i < attepmtCount.getAttemptCount(); i++) {
            RacingResult racingResult = moveCars(Condition.createConditions(cars.size()));
            RacingCarOutput.println(racingResult.getTurnResult());
        }
        Winner finalWinner = new Winner(cars);
        return finalWinner.findFinalWinningCars();
    }

    public RacingResult moveCars(List<Integer> conditions) {
        int indexOfCars = START_VALUE;
        for (Car car : cars) {
            moveCar(car, conditions.get(indexOfCars++));
        }

        RacingResult racingResult = new RacingResult(cars);
        racingResult.raceTurnResult();
        return racingResult;
    }

    public void moveCar(Car car, int condition) {
        car.moveForward(Condition.getStatus(condition));
    }

    public List<Car> getCars() {
        return cars;
    }
}
