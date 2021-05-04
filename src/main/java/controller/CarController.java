package controller;

import domain.Car;
import validation.CarValidation;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    public static String[] splitByComma(String inputCarName) {
        String[] car = inputCarName.split(",");
        CarValidation.isCarValidate(car);
        return car;
    }

    public static List<Car> generateCars(String inputCarName) {
        List<Car> cars = new ArrayList<>();
        for (String carName : splitByComma(inputCarName)) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }
}
