package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<String> cars;

    public Cars(String carNames) {
        cars = mapCar(carNames);
    }

    private static List<String> mapCar(String carName) {
        List<String> resVal = new ArrayList<>();
        carName = carName.replaceAll(" ", "");
        String[] cars = carName.split(",");
        for (int i = 0; i < cars.length; i++) {
            resVal.add(cars[i]);
        }
        return resVal;
    }
}
