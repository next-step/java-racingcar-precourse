package racinggame;

import java.util.ArrayList;

import static racinggame.ErrorMessage.ERROR_MESSAGE;

public class RacingGame {
    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public Cars play() {
        cars.play();

        return cars;
    }
}
