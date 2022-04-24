package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {
    private List<Car> carList;


    public Racing(String carListNames) {
        String[] cars = carListNames.split(",");
        carList = new ArrayList<>();
        for (String carName : cars) {
            carList.add(Car.withName(carName));
        }
    }

    public void moveCheck(){
        for (Car car : carList) {
            car.update();
            System.out.println(car.getLaps());
        }
    }


}