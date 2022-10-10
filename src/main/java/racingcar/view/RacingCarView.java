package racingcar.view;

import racingcar.domain.Winners;
import racingcar.domain.dto.RacingCarDTOList;

public interface RacingCarView {
    String getRacingCarNames();

    String getAttemptRaceCount();

    void printException(Exception exception);

    void printRace(RacingCarDTOList mapCarListToDto);

    void printResult(Winners winners);
}
