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


}
