package racingcar;

import java.util.*;

public class Cars {
    TreeMap<String, Car> carHashMap;

    private void addCar(String name) {
        if (!ValidationUtils.isValidName(name)) return;

        carHashMap.put(name, new Car(name));
    }

    public Cars() {
        carHashMap = new TreeMap<>();
    }

    public Cars(String[] carNames) {
        this();

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

    public void playRound() {
        carHashMap.forEach((key, value) -> {
            value.draw();
            System.out.println(value.printCurrentPosition());
        });
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        Car maxCar = Collections.max(carHashMap.values());

        for (Map.Entry<String, Car> entry : carHashMap.entrySet()) {
            if (entry.getValue().compareTo(maxCar) == 0) {
                winners.add(entry.getValue());
            }
        }
        return winners;
    }
}
