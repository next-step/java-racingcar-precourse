package controller;

import java.util.List;

import io.Input;
import io.Result;
import models.Race;

public class RacingGame {
    public void play() {
        String[] carNames = Input.getCarNames();
        int moves = Input.getMoves();

        Race race = new Race(carNames);
        race.start(moves);

        List<String> winners = race.getWinners();
        Result.printWinners(winners);
    }
}
