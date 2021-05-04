package com.racingcar.service;

import com.racingcar.domain.Car;
import com.racingcar.domain.Cars;
import com.racingcar.domain.MovingCondition;
import com.racingcar.domain.TryCount;
import com.racingcar.domain.Winners;
import com.racingcar.io.GameDisplay;
import com.racingcar.util.RandomGenerator;

public class RacingCarGame {

    public static final Integer MAX_RANDOM_GENERATOR_VALUE = 10;

    public RandomGenerator<MovingCondition> randomGenerator;

    public RacingCarGame(RandomGenerator<MovingCondition> randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void playRacingCarGame() {
        Cars cars = GameDisplay.inputCars();
        TryCount tryCount = GameDisplay.inputTryCount();
        GameDisplay.printResultMessage();

        while (!tryCount.isFinish()) {
            tryCount = tryCount.consumeTryCount();
            movingCars(cars);
            GameDisplay.printCarResult(cars);
        }

        Winners winners = cars.electWinners();
        GameDisplay.printWinners(winners);
    }

    private void movingCars(Cars cars) {
        for (Car car : cars) {
            MovingCondition movingCondition = randomGenerator.generate(MAX_RANDOM_GENERATOR_VALUE);
            checkMovingCar(car, movingCondition);
        }
    }

    private void checkMovingCar(Car car, MovingCondition condition) {
        if (car.isCarMoving(condition)) {
            car.moveCar();
        }
    }
}
