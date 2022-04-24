package racingcar.service;

import java.util.List;
import racingcar.constant.Delimiter;
import racingcar.utils.SplitUtils;
import racingcar.vo.RacingCars;

public class RacingCarPlayService {

    public RacingCars registerRacingCars(String inputCarNames) {
        List<String> inputCarNameList = SplitUtils.splitToList(inputCarNames, Delimiter.COMMA);
        return new RacingCars(inputCarNameList);
    }

}
