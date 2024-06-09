package controller;

import model.Car;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRaceController {
    public void startRace() {
        try {
            List<String> carNames = InputView.getCarNames();
            int raceCount = InputView.getRaceCount();

            List<Car> cars = createAndInitializeCars(carNames);
            runRace(cars, raceCount);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private List<Car> createAndInitializeCars(List<String> carNames) {
        return carNames.stream()
            .map(name -> {
                Car car = new Car(name);
                car.initializePosition(); // 위치 초기화
                return car;
            })
            .collect(Collectors.toList());
    }

    private void runRace(List<Car> cars, int raceCount) {
        Random random = new Random();
        for (int i = 0; i < raceCount; i++) {
            for (Car car : cars) {
                if (random.nextInt(10) >= 4) { // 4 이상이면 전진
                    car.move();
                }
            }
        }
    }
}
