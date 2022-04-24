package racingcar.controller;

import racingcar.domain.dto.GameHistoryDto;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.NumberGenerator;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.domain.strategy.RandomNumberGenerator;
import racingcar.service.Game;
import racingcar.service.dto.GameInformation;

public class GameController {

    private static final int MOVE_CONDITION = 4;

    public void start() {
        InputView inputView = new InputView();
        GameInformation gameInformation = inputView.input();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MoveStrategy moveStrategy = new RandomMoveStrategy(MOVE_CONDITION, numberGenerator);

        Game game = Game.of(gameInformation, moveStrategy);
        GameHistoryDto gameHistoryDto = game.start();

        ResultView resultView = ResultView.from(gameHistoryDto);
        resultView.view();
    }
}
