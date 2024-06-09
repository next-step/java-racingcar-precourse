package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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

    public List<String> getWinners() {
        Map<String, Integer> positions = getPositions();
        List<String> winners = new ArrayList<>();

        int max_position = positions.values().stream()
            .max(Integer::compareTo)
            .orElseThrow(NoSuchElementException::new);

        for (String name : positions.keySet()) {
            if (positions.get(name) == max_position) {
                winners.add(name);
            }
        }
        return winners;
    }
}
