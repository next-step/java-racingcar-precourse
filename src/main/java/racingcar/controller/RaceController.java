package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.RaceResults;
import racingcar.model.Winners;
import racingcar.view.Input;
import racingcar.view.Output;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RaceController {
    private Input input;
    private Output output;
    private Race race;

    public RaceController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void raceStart() {
        race = new Race();
        handleCarNamesInput();
        handleRoundInput();
        RaceResults roundResults = null;
        while (race.open()) {
            roundResults = race.run();
            output.printResults(roundResults);
        }
        Winners winners = race.end(roundResults);
        output.printWinners(winners);
    }

    private void handleCarNamesInput() {
        try {
            readRacingCars();
        } catch (IllegalArgumentException ex) {
            output.printErrorMessage(ex.getMessage());
            readRacingCars();
        }
    }

    private void handleRoundInput() {
        try {
            readRound();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readRound();
        }
    }

    private void readRacingCars() {
        input.requireCarNames();
        String carsInput = readLine();
        race.joinRacing(carsInput);
    }

    private void readRound() {
        input.requireRound();
        String roundInput = readLine();
        race.initRound(roundInput);
    }
}
