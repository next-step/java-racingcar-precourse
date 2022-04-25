package racingcar.validation;

import org.junit.platform.commons.util.StringUtils;
import racingcar.util.ValidationUtil;

public interface CarNameValidation {

    int MAX_NAME_LENGTH = 5;
    String VALID_NAME_MESSAGE = "자동차 이름이 5자리를 초과하였습니다.";

    default String validName(String name) {
        ValidationUtil.validation(isName(name), VALID_NAME_MESSAGE);
        return name;
    }

    default boolean isName(String name) {
        return StringUtils.isNotBlank(name) && name.length() <= MAX_NAME_LENGTH;
    }
}
