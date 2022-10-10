package racingcar;

import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController race = new RacingController();
        race.startRace();
    }
}
