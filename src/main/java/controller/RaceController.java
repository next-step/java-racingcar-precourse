package controller;

import java.util.List;
import model.Race;

public class RaceController {
    private final RaceInputController inputController;

    public RaceController() {
        this.inputController = new RaceInputController();
    }

    public void run() {
        try {
            List<String> carNames = inputController.getUserInputForCarNames();
            int rounds = inputController.getUserInputForRaceCount();

            Race race = new Race(carNames, rounds);
            race.start();

            OutputView.printRaceStatus(result.getCars());
            OutputView.printWinners(result.getWinners());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
