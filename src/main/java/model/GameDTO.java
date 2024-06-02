package model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameDTO {
    private final int iteration;

    private List<CarDTO> cars;

    public GameDTO(int iteration, List<CarDTO> cars) {
        this.iteration = iteration;
        this.cars = cars;
    }

    public boolean checkMovements(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<Boolean> getCarsMovements() {
        List<Boolean> carsMovements = new ArrayList<>();
        for (CarDTO car : this.cars) {
            carsMovements.add(checkMovements(car.getRandomNumber()));
        }
        return carsMovements;
    }


}
