package model;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGameModel {
    private Car[] cars;

    public RacingGameModel(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(0, 10);
    }

    public Car[] getCars() {
        return cars;
    }

    public Car[] updateCars(int randomNumber) {
        for (Car car : cars) {
            if (randomNumber >= 4) {
                car.forward();
            }
        }
        return cars;
    }

    public Car[] generateWinner(Car[] cars) {
        int max = -1;
        List<Car> carList = new ArrayList<>();
        for (Car car : cars) {
            max = Math.max(max, car.getRaceDistance());
        }
        for (Car car : cars) {
            if (car.getRaceDistance() == max) {
                carList.add(car);
            }
        }
        return carList.toArray(new Car[0]);
    }
}
