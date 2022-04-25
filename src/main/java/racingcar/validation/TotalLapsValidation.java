package racingcar.validation;

import racingcar.util.NumberUtil;
import racingcar.util.ValidationUtil;

public interface TotalLapsValidation {

    String VALID_TOTAL_LAPS_MESSAGE = "레이싱 횟수는 숫자입니다.";

    default String validTotalLaps(String totalLaps) {
        ValidationUtil.validation(isTotalLaps(totalLaps), VALID_TOTAL_LAPS_MESSAGE);
        return totalLaps;
    }

    default boolean isTotalLaps(String totalLaps) {
        return NumberUtil.isNumber(totalLaps);
    }
}
