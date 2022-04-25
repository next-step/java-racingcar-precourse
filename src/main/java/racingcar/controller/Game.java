package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.Input;

public class Game {

    private final Racing racing;

    public Game(Input input) {
        this.racing = new Racing(input.getRacingCars(), input.getTotalRound());
    }

    public void run() {
        racing.play();
    }

    public Winners getWinners() {
        return racing.getWinners();
    }

    public Rounds getRoundsResult() {
        return racing.getRounds();
    }
}
