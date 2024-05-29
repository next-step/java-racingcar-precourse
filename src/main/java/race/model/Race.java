package race.model;

import java.util.*;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> carList;
    private final CustomRandom random;

    public Race(List<Car> carList, CustomRandom random) {
        this.carList = carList;
        this.random = random;
    }

    public List<Car> proceedStep() {
        for (Car car : carList) {
            if (random.canMove())
                car.moveForward();
        }
        return carList;
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
