package racingcar.controlelr;

import racingcar.common.SplitUtil;
import racingcar.common.strategy.RandomNumber;
import racingcar.model.Car;
import racingcar.model.Participate;
import racingcar.model.RacingGame;
import racingcar.model.dto.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void init() {
        List<Car> participant = inputCarName();

        List<RacingResult> result = new RacingGame(participant)
                .start(new RandomNumber(), new InputView().getRacingCount());

        OutputView.endGame();
        printRacingResult(result);
        printWinner(result);
    }

    private List<Car> inputCarName() {
        try {
            return new Participate().addCar(SplitUtil.carSplit(new InputView().getCarName()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarName();
        }

        return null;
    }

    private void printWinner(List<RacingResult> result) {
        List<String> winner = new ArrayList<>();
        for (RacingResult racingResult : result) {
            addWinner(winner, racingResult);
        }

        OutputView.winnerResult(winner);
    }

    private void addWinner(List<String> winner, RacingResult racingResult) {
        if (racingResult.isWinner) {
            winner.add(racingResult.getName());
        }
    }

    private void printRacingResult(List<RacingResult> racingResult) {
        for (RacingResult result : racingResult) {
            OutputView.gameResult(result);
        }
    }
}
