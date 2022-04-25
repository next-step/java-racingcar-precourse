package racingcar.game;

import racingcar.race.CarDto;
import racingcar.race.Race;
import racingcar.rule.MoveCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final Race race = createRace();
        final MoveCount moveCount = createMoveCount();
        final List<List<CarDto>> result = race.startWith(moveCount);
        outputView.printResult(result);
        final List<String> winners = race.getWinner();
        outputView.printWinners(winners);
    }

    Race createRace() {
        try {
            final String names = inputView.inputCarsNames();
            final String[] carNames = names.split(",");
            return Race.from(carNames);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createRace();
        }
    }

    MoveCount createMoveCount() {
        try {
            final String inputMoveCount = inputView.inputMoveCount();
            return MoveCount.fromString(inputMoveCount);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createMoveCount();
        }
    }
}
