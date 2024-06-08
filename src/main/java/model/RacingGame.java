package model;

import view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final Random random = new Random();
    private final ResultView resultView = new ResultView();

    public RacingGame(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race(int trials) {
        System.out.println();
        System.out.println("최종 결과");
        for (int i = 0; i < trials; i++) {
            cars.forEach(car -> car.move(random));
            resultView.printRaceStatus(cars);
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
