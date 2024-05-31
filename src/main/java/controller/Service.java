package controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import model.Car;

public class Service {

    private static Service instance;

    public static synchronized Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {}

    private Random random = new Random();

    public List<Integer> generatePercent(Integer carLength) {
        return random.ints(carLength, 0, 10).boxed().collect(Collectors.toList());
    }

    public void moveCars(List<Car> cars, List<Integer> percents) {
        cars.forEach(car -> {
            if (percents.get(cars.indexOf(car)) >= 4) {
                car.move();
            }
        });
    }

    public List<Car> getWinner(List<Car> cars) {
        Integer maxDistance = cars.stream().map(Car::getDistance).max(Integer::compareTo).orElse(0);
        return cars.stream().filter(car -> car.getDistance().equals(maxDistance))
                .collect(Collectors.toList());
    }
}
