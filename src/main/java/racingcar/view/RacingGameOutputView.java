package racingcar.view;

import racingcar.domain.dto.PlayHistories;

import java.util.List;

public interface RacingGameOutputView {

    void outputTotalPlayHistories(final List<PlayHistories> playHistoriesList);

    void outputWinner(final List<String> winnersCarNames);

    void outputErrorMessage(String errorMessage);
}