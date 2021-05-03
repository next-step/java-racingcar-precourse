package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {

    private RacingCarFactory() {}

    private static List<RacingCar> racingCars;

    public static List<RacingCar> create(String carsName) {
        racingCars = new ArrayList<>();
        String[] carNames = carsName.split(",");

        for (String carName : carNames) {
            generateIfNameCountBetweenOneAndFive(carName);
        }

        return racingCars;
    }

    private static void generateIfNameCountBetweenOneAndFive(String carName) {
        if (Validation.checkNameLength(carName)) {
            RacingCar racingCar = new RacingCar(carName);
            racingCars.add(racingCar);
        }
    }
}
