package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.GameHistories;
import racingcar.dto.GameResult;
import racingcar.model.Cars;
import racingcar.model.GameRound;
import racingcar.view.inputView;

public class RacingCarGameServiceImpl implements RacingCarGameService {

    @Override
    public Cars gameCars() {
        while (true) {
            try {
                return new Cars(inputView.inputCarNames());
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    @Override
    public GameRound gameRounds() {
        while (true) {
            try {
                return new GameRound(inputView.inputTry());
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    @Override
    public List<GameHistories> gamePlay(Cars cars, GameRound gameRound) {
        List<GameHistories> gamePlayHistories = new ArrayList<>();
        int round = gameRound.getGameRound();

        while (round-- > 0) {
            gamePlayHistories.add(cars.getHistories());
        }

        return gamePlayHistories;
    }

    @Override
    public GameResult gameWinners(Cars cars) {
        return cars.getWinners();
    }
}
