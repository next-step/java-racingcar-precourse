package racingcar.model;

import racingcar.constant.Symbol;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public String race(Count count) {
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < count.getAttemptCount() ; i++) {
            move(Condition.createConditions(cars.size()));
            result.append(turnRaceResult());
        }
        return result.toString();
    }

    public void move(List<Integer> condtions) {
        for(int i = 0 ; i < cars.size() ; i++) {
            cars.get(i).moveForward(Condition.getStatus(condtions.get(i)));
        }
    }

    public String searchFinalWinner() {
        Winner finalWinner = new Winner(cars);
        return finalWinner.searchFinalWinningCars();
    }

    private String turnRaceResult() {
        StringBuilder turnResult = new StringBuilder();
        for(Car car : cars) {
            CarName carName = car.getName();
            turnResult.append(carName.getName())
                    .append(Symbol.COLON.getValue())
                    .append(car.getPosition())
                    .append(Symbol.LINE.getValue());
        }

        return turnResult.append(Symbol.LINE.getValue()).toString();
    }

    public List<Car> getCars() {
        return cars;
    }
}
