package kim.half.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        this.cars = createCars(names);
    }

    private List<Car> createCars(String inputNames) {
        String[] names = inputNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void runCars() {
        for (Car car : cars) {
            car.run(generateRandomNumber());
        }
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int generateRandomNumber() {
        return ThreadLocalRandom.current()
            .nextInt(Rule.MIN_NUMBER.value(), Rule.MAX_NUMBER.value() + 1);
    }

    private int getMaxDistance() {
        return cars.stream()
            .mapToInt(Car::getDistance)
            .max()
            .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
