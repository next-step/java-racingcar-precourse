package racingcar.model;

import java.util.List;

public class Cars {
    private static final int START_VALUE = 0;

    private final List<Car> cars;
    private RacingResult racingResult;

    public Cars(List<Car> cars) {
        this.cars = cars;
        this.racingResult = new RacingResult(cars);
    }

    public ResultView race(AttemptCount attepmtCount) {
        ResultView resultView = new ResultView();
        for (int i = START_VALUE; i < attepmtCount.getAttemptCount(); i++) {
            racingResult = moveCars(Condition.createConditions(cars.size()));
            resultView.merge(racingResult.raceTurnResult());
        }

        return resultView;
    }

    public String findFinalWinner() {
        Winner finalWinner = new Winner(cars);
        return finalWinner.findFinalWinningCars();
    }

    public RacingResult moveCars(List<Integer> conditions) {
        int indexOfCars = START_VALUE;
        for (Car car : cars) {
            moveCar(car, conditions.get(indexOfCars++));
        }

        return  new RacingResult(cars);
    }

    public void moveCar(Car car, int condition) {
        car.moveForward(Condition.getStatus(condition));
    }

    public List<Car> getCars() {
        return cars;
    }
}
