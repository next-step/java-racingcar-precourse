package controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import model.Car;

public class Service {

    private Random random = new Random();

    public List<Integer> generatePercent(Integer carLength) {
        return random.ints(carLength, 0, 10)
                .boxed()
                .collect(Collectors.toList());
    }

    public void moveCars(List<Car> cars, List<Integer> percents) {
        cars.forEach(car -> {
            if (percents.get(cars.indexOf(car)) >= 4) {
                car.move();
            }
        });
    }
}
