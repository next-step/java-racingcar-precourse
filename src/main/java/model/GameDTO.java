package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameDTO {
    private List<CarDTO> cars;
    private final int iteration;

    public GameDTO(List<CarDTO> cars, int iteration) {
        this.cars = cars;
        this.iteration = iteration;
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


}
