package model;

import java.util.*;

public class GameDTO {
    private List<CarDTO> cars;
    private final int iteration;
    private Map<String, Integer> records;

    public GameDTO(@NotNull List<CarDTO> cars,@NotNull int iteration) {
        this.cars = cars;
        this.iteration = iteration;
        this.records = new LinkedHashMap<>();
        for (CarDTO car : cars) {
            records.put(car.getName(), 0);
        }
    }

    private boolean checkMovements(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<Boolean> getCarsMovements() {
        List<Boolean> carsMovements = new ArrayList<>();
        for (CarDTO car : this.cars) {
            carsMovements.add(checkMovements(car.getRandomNumber()));
        }
        return carsMovements;
    }

    public List<String> getCarNames() {
        List<String> carNameList = new ArrayList<>();
        for (CarDTO car : cars) {
            carNameList.add(car.getName());
        }
        return carNameList;
    }

    public int getIteration() {
        return this.iteration;
    }


    public Map<String, Integer> getRecords() {
        return records;
    }

    public void addMovements(String carName) {
        this.records.replace(carName, this.records.get(carName) + 1);
    }
}
