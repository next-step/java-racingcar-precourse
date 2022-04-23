package racingcar.service;

import racingcar.domain.*;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingGameService {

    public void run() {

        Cars cars = setCars();
        Round round = setRound();

        showMsgGameResult();

        while (!round.isGameEnd()) {
            round.turnRound();
            cars.move();
            showCarsPath(cars);
        }
        showWinners(cars);
    }

    public Cars setCars() {
        Cars cars = null;
        try {
            cars = new Cars(inputCarNames());
            return cars;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCars();
        }
        return cars;
    }

    public Round setRound() {
        Round round = null;
        try {
            round = new Round(inputMoveCount());
            return round;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setRound();
        }
        return round;
    }

}
