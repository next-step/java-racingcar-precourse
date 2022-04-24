package racingcar.service;

import racingcar.domain.dto.PlayHistories;
import racingcar.domain.model.Cars;
import racingcar.domain.model.Round;

import java.util.List;

public interface RacingGameService {
    Cars readyToCars(String carNames);

    Round readyToRound(String round);

    List<PlayHistories> play(Cars cars, Round round);
}