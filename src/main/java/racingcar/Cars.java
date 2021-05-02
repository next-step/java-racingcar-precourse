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

        addCars(carNames);
    }

    public boolean hasCar(String name) {
        return carHashMap.containsKey(name);
    }

    public int getNumOfCars() {
        return carHashMap.size();
    }

    public void addCars(String[] carNames) {
        for (String carName : carNames) {
            addCar(carName);
        }
    }
}
