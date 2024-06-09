package controller;

import java.util.List;
import model.Car;
import model.Race;
import view.OutputView;

public class RaceController {
    private final Race race;
    private final int rounds;

    public RaceController(Race race, int rounds) {
        this.race = race;
        this.rounds = rounds;
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            race.start();
            OutputView.printRaceStatus(race);
        }

        List<Car> result = race.judgeWinners();
        OutputView.printWinners(result);
    }
}
