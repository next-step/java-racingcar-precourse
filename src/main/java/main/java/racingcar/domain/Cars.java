package main.java.racingcar.domain;

import main.java.racingcar.Utils;
import java.util.List;

public record Cars(List<Car> CarList) {

    public static final String CAR_NAME_DELIMITER = ",";

    public static Cars createByString(String carsString) {
        List<Car> carList = Utils.splitByDelimiter(carsString, CAR_NAME_DELIMITER)
                .stream()
                .map(CarName::new)
                .map(Car::new)
                .toList();
        return new Cars(carList);
    }
}
