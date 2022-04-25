package racingcar.validation;

import racingcar.util.NumberUtil;
import racingcar.util.ValidationUtil;

public interface TotalLapsValidation {

    String VALID_TOTAL_LAPS_MESSAGE = "레이싱 횟수는 숫자입니다.";
    String VALID_MAX_TOTAL_LAPS_MESSAGE = "레이싱 횟수는 10000번으로 제한합니다.";
    Integer MAX_TOTAL_LAPS = 10000;

    default Integer validTotalLaps(String totalLapsStr) {
        ValidationUtil.validation(isTotalLaps(totalLapsStr), VALID_TOTAL_LAPS_MESSAGE);

        Integer totalLaps = Integer.parseInt(totalLapsStr);

        ValidationUtil.validation(isMaxTotalLaps(totalLaps), VALID_MAX_TOTAL_LAPS_MESSAGE);
        return totalLaps;
    }

    default boolean isTotalLaps(String totalLaps) {
        return NumberUtil.isNumber(totalLaps);
    }

    default boolean isMaxTotalLaps(Integer totalLaps) {
        return totalLaps <= MAX_TOTAL_LAPS;
    }
}
