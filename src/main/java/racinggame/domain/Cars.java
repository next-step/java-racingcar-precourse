package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<String> cars;
    public static Validation validation = new Validation();

    public Cars(String carNames) {
        cars = mapCar(carNames);
    }

    private static List<String> mapCar(String carName) {
        List<String> resVal = new ArrayList<>();
        String[] cars = carName.split(",");
        for (int i = 0; i < cars.length; i++) {
            resVal.add(cars[i]);
        }
        return resVal;
    }

}
