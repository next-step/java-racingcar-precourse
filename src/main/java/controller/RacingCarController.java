package controller;

import model.Car;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarController {

    private InputView inputView;
    private OutputView outputView;
    private Random random;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    public void run() {
        List<Car> cars = getCarNames();
        int racingCount = getRacingCount();
        outputView.printOutput();
        List<Car> result = race(cars, racingCount);
        List<String> winners = getWinner(result);
        outputView.printWinners(winners);
    }

    public List<Car> getCarNames() {
        while (true) {
            try {
                return Arrays.stream(inputView.inputCarNames().split(","))
                        .map(Car::new)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public int getRacingCount() {
        while (true) {
            try {
                return inputView.inputRacingCount();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public List<Car> race(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            attempt(cars);
            System.out.println();
        }
        return cars;
    }

    public void attempt(List<Car> cars) {
        for (Car car : cars) {
            if (random.nextInt(10) >= 4) {
                car.moveForward();
            }
            outputView.printRacingCar(car.getName(), car.getPosition());
        }
    }

    public List<String> getWinner(List<Car> cars) {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
