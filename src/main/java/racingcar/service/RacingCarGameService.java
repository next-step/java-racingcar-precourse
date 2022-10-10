package racingcar.service;

import java.util.List;
import racingcar.dto.GameHistories;
import racingcar.dto.GameResult;
import racingcar.model.Cars;
import racingcar.model.GameRound;

public interface RacingCarGameService {

    public Cars gameCars();

    public GameRound gameRounds();

    public List<GameHistories> gamePlay(Cars cars, GameRound gameRound);

    public GameResult gameWinners(Cars cars);
}
