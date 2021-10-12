package racinggame.car.utils;

import racinggame.Enum.Error;
import racinggame.car.domain.Car;
import racinggame.car.domain.CarName;
import racinggame.car.domain.Cars;
import racinggame.race.domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CarsUtil {
    public static int CAR_MIN_LENGTH = 1;
    public static int CAR_MAX_LENGTH = 5;
    private static String ERROR_MSG = "[ERROR]";

    public static String[] makeCarStringToAry(String carsNameStr) {
        return carsNameStr.split("\\s*,\\s*");
    }

    public static boolean validationCarName(String carName) {
        return carName.length() >= CAR_MIN_LENGTH && carName.length() <= CAR_MAX_LENGTH;
    }

    public static String CarName(String inputName) {
        String inputTrimName = inputName.trim();
        if (!CarsUtil.validationCarName(inputTrimName)) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
        return inputName;
    }

    public static List<Car> createCars(List<CarName> inputData) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : inputData) {
            cars.add(new Car(carName, new Position()));
        }

        return cars;
    }
}
