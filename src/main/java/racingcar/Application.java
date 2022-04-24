package racingcar;

import racingcar.race.RaceController;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController();
        raceController.start();
    }
}
