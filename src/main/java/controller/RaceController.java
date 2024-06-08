package controller;

import java.util.List;
import model.Car;
import model.Race;
import view.OutputView;

public class RaceController {
    private final RaceInputController inputController;

    public RaceController() {
        this.inputController = new RaceInputController();
    }

    public void run() {
        List<String> carNames = inputController.getUserInputForCarNames();
        int rounds = inputController.getUserInputForRaceCount();

        Race race = new Race(carNames, rounds);
        List<Car> result = race.start();

        OutputView.printRaceStatus(result);
        OutputView.printWinners(result);
    }
}
