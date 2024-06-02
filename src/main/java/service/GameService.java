package service;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;
import model.Cars;
import utils.RandomNumberGenerator;

public class GameService {

    private final Cars cars;

    public GameService() {
        cars = new Cars();
    }

    public void init(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public List<Car> playRound() {
        for (Car car : cars.getCars()) {
            car.moveOrNot(RandomNumberGenerator.generate());
        }
        return cars.getCars();
    }

    public List<Car> whosTheWinner() {
        int max = findMaxStep();
        return cars.getCars().stream()
                        .filter(car -> car.getStep().equals(max))
                        .collect(Collectors.toList());
    }

    private int findMaxStep() {
        return cars.getCars().stream()
                        .mapToInt(Car::getStep)
                        .max().orElse(0);
    }
}
