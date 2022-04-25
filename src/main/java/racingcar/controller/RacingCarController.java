package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCarModel;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final RacingCarView racingCarView;
    private final RacingCarModel racingCarModel;

    public RacingCarController(RacingCarView racingCarView, RacingCarModel racingCarModel) {
        this.racingCarView = racingCarView;
        this.racingCarModel = racingCarModel;
    }

    public void play() {
        init();
    }

    private void init() {
        while(!racingCarModel.isValidGame()) {
            String playerName = getInputCarName();
            newGame(playerName);
        }
        while(!racingCarModel.isValidTry()) {
            String tryCount = getInputTryCount();
            play(tryCount);
        }
        printResult();
    }

    private void newGame(String playerName) {
        try {
            racingCarModel.init(playerName);
        } catch (IllegalArgumentException ex) {
            racingCarView.printError(ex.getMessage());
        }
    }

    private void play(String tryCount) {
        try {
            racingCarModel.run(tryCount);
        } catch (IllegalArgumentException ex) {
            racingCarView.printError(ex.getMessage());
        }
    }

    private String getInputCarName() {
        racingCarView.printInputCarName();
        String playerName = Console.readLine();
        return playerName;
    }

    private String getInputTryCount() {
        racingCarView.printInputRunCount();
        String tryCount = Console.readLine();
        return tryCount;
    }

    private void printResult() {
        racingCarView.printStatus(racingCarModel.getStatus(), racingCarModel.getPlayer());
        racingCarView.printWinner(racingCarModel.getWinner());
    }
}
