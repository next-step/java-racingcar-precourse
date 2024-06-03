package model;

import vo.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public List<String> splitByComma (String names) {
        return Arrays.stream(names.trim().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

}
