package racingcar.domain.racing.car;

import static racingcar.domain.constant.RacingGameConfiguration.CAR_NAME_DELIMITER;
import static racingcar.domain.constant.RacingGameConfiguration.STARTING_POINT;
import static racingcar.domain.constant.RacingGameExceptions.EMPTY_NAME_ERROR;
import static racingcar.domain.constant.RacingGameExceptions.NULL_NAME_ERROR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import racingcar.exception.RacingCarGameException;

public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    private Cars(String carNames) {
        validate(carNames);
        carList = generateCars(carNames);
    }

    public static Cars from(String carNames) {
        return new Cars(carNames);
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int count() {
        return carList.size();
    }

    private List<Car> generateCars(String carNames) {
        List<Car> cars = new ArrayList<>();

        List<String> carNameList = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
        for (String carName : carNameList) {
            cars.add(Car.of(carName.trim(), STARTING_POINT));
        }
        return cars;
    }

    private void validate(String carNames) {
        validateNonNull(carNames);
        validateEmpty(carNames);
    }

    private void validateEmpty(String carNames) {
        if (carNames.isEmpty()) {
            throw illegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    private void validateNonNull(String value) {
        if (Objects.isNull(value)) {
            throw illegalArgumentException(NULL_NAME_ERROR);
        }
    }

    private IllegalArgumentException illegalArgumentException(String errorMessage) {
        return RacingCarGameException.throwIllegalArgumentException(errorMessage);
    }
}