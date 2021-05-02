package racingcar;

import java.util.HashMap;

public class Cars {
    HashMap<String, Car> carHashMap;

    private void addCar(String name) {
        if (!ValidationUtils.isValidName(name)) return;

        carHashMap.put(name, new Car(name));
    }

    public Cars(String[] carNames) {
        carHashMap = new HashMap<>();

        for (String carName : carNames) {
            addCar(carName);
        }
    }

    public boolean hasCar(String name) {
        return carHashMap.containsKey(name);
    }
}
