package racinggame;

import java.util.ArrayList;

import static racinggame.ErrorMessage.ERROR_MESSAGE;

public class RacingGame {
    private int count;
    private Cars cars;

    public RacingGame(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void play() {
        for (int i = 0; i < count; i++) {
            cars.play();
        }
    }
}
