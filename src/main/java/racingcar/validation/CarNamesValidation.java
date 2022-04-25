package racingcar.validation;

import org.junit.platform.commons.util.StringUtils;
import racingcar.util.ValidationUtil;

public interface CarNamesValidation {

    String VALID_NAMES_MESSAGE = "자동차 이름이 없습니다";

    default String validCarNames(String carNames) {
        ValidationUtil.validation(isCarNames(carNames), VALID_NAMES_MESSAGE);
        return carNames;
    }

    default boolean isCarNames(String carNames) {
        return StringUtils.isNotBlank(carNames);
    }
}
