package racingcar.view;

import racingcar.model.record.RacingRecord;

import java.util.List;

public interface GameOutput {
    void inputCarNames();

    void inputLapCount();

    void showRacingRecord(RacingRecord racingRecord);

    void showChampions(List<String> champions);

    void error(String message);
}
