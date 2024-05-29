package race.model;

import java.util.*;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> carList;

    public Race(List<Car> carList) {
        this.carList = carList;
    }

    public void proceedStep(CustomRandom random) {
        for (Car car : carList) {
            if (random.canMove())
                car.moveForward();
        }
    }

    public List<Car> getWinnerList() {
        return carList.stream()
                .collect(Collectors.groupingBy(Car::getPosition))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(new ArrayList<>());
    }
}
