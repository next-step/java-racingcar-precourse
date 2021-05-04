package me.ascii92der.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carGroup;
    private static final String SEPARATE_CHAR = ",";


    public Cars(String carNames) {
        carGroup = new ArrayList<>();
        for (String carName : carNames.split(SEPARATE_CHAR)) {
            carGroup.add(new Car(carName));
        }
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }

    public void moves() {
        for (Car car : carGroup) {
            car.moveCar(RandomUtil.generateRandomNumber());
        }
    }
}
