package racingcar.controller;

import racingcar.model.Cars;

public class RacingCarController {

    public Cars play(Cars cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            cars.move();
        }
        return cars;
    }

}
