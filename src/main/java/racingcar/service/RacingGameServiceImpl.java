package racingcar.service;

import racingcar.core.common.helper.PickNumberStrategy;
import racingcar.domain.dto.PlayHistories;
import racingcar.domain.model.Cars;
import racingcar.domain.model.Round;

import java.util.ArrayList;
import java.util.List;

public class RacingGameServiceImpl implements RacingGameService {

    private final PickNumberStrategy pickNumberStrategy;

    public RacingGameServiceImpl(PickNumberStrategy pickNumberStrategy) {
        this.pickNumberStrategy = pickNumberStrategy;
    }

    @Override
    public Cars readyToCars(final String carNames) {
        return new Cars(carNames, pickNumberStrategy);
    }

    @Override
    public Round readyToRound(final String round) {
        return new Round(round);
    }

    @Override
    public List<PlayHistories> play(final Cars cars, final Round round) {
        final List<PlayHistories> totalPlayHistories = new ArrayList<>();
        int roundCount = round.getRound();

        while (roundCount-- > 0) {
            totalPlayHistories.add(cars.racing());
        }

        return totalPlayHistories;
    }
}