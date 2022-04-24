package racingcar.controller;

import racingcar.model.CarMovableStrategy;
import racingcar.model.Cars;
import racingcar.model.GameRound;
import racingcar.model.MovableStrategy;
import racingcar.view.ResultView;

public class RacingMachine {

    public RacingMachine() {
    }

    public Cars start(String[] names, int round) {
        MovableStrategy movableStrategy = new CarMovableStrategy();
        Cars cars = Cars.of(names, movableStrategy);

        ResultView resultView = new ResultView();

        resultView.printRacingEndMessage();

        GameRound gameRound = new GameRound(round);

        while(!gameRound.isEnd()) {
            gameRound.reduceRound();

            cars.move();

            resultView.printPosition(cars);
        }

        String winners = cars.findWinners(round);

        resultView.printWinners(winners);

        return cars;
    }
}
