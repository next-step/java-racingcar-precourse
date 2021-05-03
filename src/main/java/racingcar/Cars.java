package racingcar;

import java.util.*;

public class Cars {
    TreeMap<String, Car> carMap;

    private void addCar(String name) {
        if (!ValidationUtils.isValidName(name)) return;

        carMap.put(name, new Car(name));
    }

    public Cars() {
        carMap = new TreeMap<>();
    }

    public Cars(String[] carNames) {
        this();

        addCars(carNames);
    }

    public boolean hasCar(String name) {
        return carMap.containsKey(name);
    }

    public int getNumOfCars() {
        return carMap.size();
    }

    public void addCars(String[] carNames) {
        for (String carName : carNames) {
            addCar(carName);
        }
    }

    public void playRound() {
        carMap.forEach((key, value) -> {
            value.draw();
            System.out.println(value.printCurrentPosition());
        });
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        Car maxCar = Collections.max(carMap.values());

        carMap.forEach((key, value) -> {
            if (value.compareTo(maxCar) == 0) {
                winners.add(value);
            }
        });

        return winners;
    }
}
