package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import view.OutputView;

public class Game {

    private final List<Car> cars;
    private final int numberOfAttempts;
    private final Random random = new Random();
    private final OutputView outputView = new OutputView();

    public Game(List<Car> cars, int numberOfAttempts) {
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public void playGame() {
        outputView.printHead();
        playRounds();
    }

    private void playRounds() {
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.forEach(this::moveCarAndPrintDistance);
            System.out.println();
        }
    }

    private void moveCarAndPrintDistance(Car car) {
        if (random.nextInt(10) >= 4) {
            car.move();
        }
        outputView.printDistance(car);
    }

    public List<Car> getWinners() {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        return cars.stream().filter(car -> car.getDistance() == maxDistance)
            .collect(Collectors.toList());
    }

}
