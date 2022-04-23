package racingcar.game;

import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
import racingcar.input.MoveCountInput;
import racingcar.input.RacingCarInput;
import racingcar.input.validator.CarNamesValidatorGroup;
import racingcar.input.validator.impl.MoveCountValidator;
import racingcar.view.output.OutputView;

public class RacingGame {
    public static void play() {
        RacingCarInput racingCarInput = new RacingCarInput(new CarNamesValidatorGroup());
        Cars cars = new Cars(racingCarInput.getCarNames());

        MoveCountInput moveCountInput = new MoveCountInput(new MoveCountValidator());
        MoveCount moveCount = moveCountInput.getMoveCount();

        Race race = new Race(cars, moveCount);
        race.start();

        RaceJudgment raceJudgment = new RaceJudgment(cars);
        OutputView.printWinners(raceJudgment.getWinners());
    }
}
