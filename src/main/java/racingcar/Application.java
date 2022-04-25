package racingcar;

import racingcar.controller.RaceController;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(new Input(), new Output());
        raceController.raceStart();
    }
}
