package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.CarName;
import racinggame.domain.Cars;
import racinggame.domain.InputCarsName;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    public String[] splitNameWithComma(InputCarsName inputCarsName) {
        return inputCarsName.getName().split(",");
    }

    public Cars createCars(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            carList.add(Car.of(CarName.of(name)));
        }
        return Cars.of(carList);
    }
}
