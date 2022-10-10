package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.ConstantNumber;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameNumber;

public class RaceService {

    public Cars returnCars(String carsNameInput) {
        String[] splittedCarNames = carsNameInput.split(",");
        try {
            return createCars(splittedCarNames);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s: %n", e.getMessage());
        }
        return null;
    }

    private Cars createCars(String[] splitCars) {
        List<String> carNames = Arrays.asList(splitCars);
        return new Cars(carNames);
    }


    public void move(Cars cars) {
        for (Car car : cars.getValue()) {
            car.move();
        }
    }

    public Cars detectWinner(Cars competitors) {
        int max = ConstantNumber.ZERO;
        Cars winnerCars = new Cars();
        for (Car car : competitors.getValue()) {
            max = getMax(max, winnerCars, car);
            addCoWinner(max, winnerCars, car);
        }
        return winnerCars;
    }

    protected void addCoWinner(int max, Cars winnerCars, Car car) {
        boolean doesCarHasMaxValue = max == car.getPositionInteger();
        boolean isWinnerNameSame = false;
        for (Car winner : winnerCars.getValue()) {
            isWinnerNameSame = winner.getName().getValue().equals(car.getNameInString());
        }
        if (doesCarHasMaxValue && !isWinnerNameSame) {
            winnerCars.getValue().add(car);
        }
    }

    protected int getMax(int max, Cars winnerCars, Car car) {
        if (max == ConstantNumber.ZERO || max < car.getPositionInteger()) {
            max = car.getPositionInteger();
            winnerCars.getValue().clear();
            winnerCars.getValue().add(car);
        }
        return max;
    }

    public String makePrintableWinners(Cars winners) {
        if (winners.isSoleWinner(winners)) {
            return winners.getValue().get(0).getNameInString();
        }
        StringBuilder winnerNames = new StringBuilder();
        for (Car car : winners.getValue()) {
            winnerNames.append(", ");
            winnerNames.append(car.getNameInString());
        }
        return winnerNames.substring(ConstantNumber.EXCLUDE_FIRST_LETTER).trim();
    }

    public Cars beginRace(GameNumber gameNumber, Cars cars) {
        for (int i = 0; i < gameNumber.getValue(); i++) {
            move(cars);
        }
        return cars;
    }


}

