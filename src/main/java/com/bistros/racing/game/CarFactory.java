package com.bistros.racing.game;

import com.bistros.racing.domain.Car;
import com.bistros.racing.exception.InvalidUserInputDataException;

import java.util.*;

public class CarFactory {

    public static List<Car> generateCars(String userInput) {
        if (userInput == null || userInput.equals("")) {
            throw new InvalidUserInputDataException();
        }
        String[] names = userInput.trim().split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
