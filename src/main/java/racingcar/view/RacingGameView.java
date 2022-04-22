package racingcar.view;

import java.util.List;
import racingcar.car.RacingCarDTO;
import racingcar.car.RacingCarName;

public interface RacingGameView {
    String takeRacingCarNames();

    String takeRacingStageCount();

    void printStageStart();

    void printStageResult(List<RacingCarDTO> racingCarDTOList);

    void printWinner(List<RacingCarName> winners);

    void printErrorMessage(Exception e);
}
