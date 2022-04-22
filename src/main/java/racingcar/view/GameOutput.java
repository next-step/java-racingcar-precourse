package racingcar.view;

import racingcar.dto.RacingRecordDto;

import java.util.List;

public interface GameOutput {
    void inputCarNames();

    void inputLapCount();

    void showRacingRecord(RacingRecordDto racingRecord);

    void showWinners(List<String> winnerNames);

    void error(String message);
}
