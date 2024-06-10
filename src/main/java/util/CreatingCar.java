package util;

import domain.RacingCar;
import domain.RacingCars;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class CreatingCar {
    private static final int START_LOCATION = 0;

    public static RacingCars createCars(final String[] carNames) {
        List<RacingCar> cars = makeCars(carNames);
        return new RacingCars(cars);
    }

    private static List<RacingCar> makeCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(CreatingCar::makeCar)
                .collect(Collectors.toList());
    }

    private static RacingCar makeCar(final String carName) {
        return new RacingCar(carName, START_LOCATION);
    }
}
