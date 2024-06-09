package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Car> cars;

    public Game(List<String> names) {
        this.cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private Map<String, Integer> getPositions() {
        Map<String, Integer> positions = new LinkedHashMap<>();
        for (Car car : cars) {
            positions.put(car.getName(), car.getPosition());
        }
        return positions;
    }

    public Map<String, Integer> play() {
        for (Car car : cars) {
            car.tryMove();
        }
        return getPositions();
    }
}
