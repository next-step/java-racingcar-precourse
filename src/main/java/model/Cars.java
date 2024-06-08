package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int CAR_COUNT_LOWER_BOUND = 2;

    private final List<Car> cars;

    public Cars(String[] carNames) {
        validateCarCount(carNames);
        validateDuplicateCarName(carNames);
        cars = convertToCarList(carNames);
    }

    public CarStates moveCars(CarMoveRule carMoveRule) {
        List<CarState> carStates = new ArrayList<>();
        for (Car car : cars) {
            CarState carState = car.moveOrStay(carMoveRule);
            carStates.add(carState);
        }
        return new CarStates(carStates);
    }

    private void validateCarCount(String[] carNames) {
        if (carNames.length < CAR_COUNT_LOWER_BOUND) {
            throw new IllegalArgumentException("[ERROR] 경주를 시작하려면 최소 2대 이상의 자동차가 필요합니다.");
        }
    }

    private void validateDuplicateCarName(String[] carNames) {
        if (carNames.length != getDistinctCount(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private int getDistinctCount(String[] carNames) {
        return (int) Arrays.stream(carNames)
            .distinct()
            .count();
    }

    private List<Car> convertToCarList(String[] carNames) {
        return Arrays.stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }
}