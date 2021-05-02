package racingcar;

import java.util.HashMap;

public class Cars {
    HashMap<String, Car> carHashMap;

    public Cars(String[] carNames) {
        carHashMap = new HashMap<>();

        for (String carName : carNames) {
            carHashMap.put(carName, new Car(carName));
        }
    }

    public boolean hasCar(String name) {
        return carHashMap.containsKey(name);
    }
}
