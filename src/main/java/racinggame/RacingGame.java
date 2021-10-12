package racinggame;

import java.util.ArrayList;
import java.util.List;

import static racinggame.ErrorMessage.ERROR_MESSAGE;

public class RacingGame {
    private int count;
    private Cars cars;

    public RacingGame(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public Cars play() {
        cars.play();

        return cars;
    }

    public int getCount() {
        return count;
    }

    public List<String> getWinners() {
        return cars.getTopPlayer();
    }
}
