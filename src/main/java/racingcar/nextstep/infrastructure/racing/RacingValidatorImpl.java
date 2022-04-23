package racingcar.nextstep.infrastructure.racing;

import org.junit.platform.commons.util.StringUtils;
import racingcar.nextstep.domain.racing.service.RacingValidator;
import racingcar.nextstep.global.message.ErrorMessage;
import racingcar.nextstep.global.message.Number;

import java.util.regex.Pattern;

public class RacingValidatorImpl implements RacingValidator {

    private static final Pattern isNumber = Pattern.compile("^[0-9]*$");

    @Override
    public void isNumber(String input) {
        if (!isNumber.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }
    }

    @Override
    public void isCarNameNotExceedingFive(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            if (isExceedingFive(splitCarName)) {
                throw new IllegalArgumentException(ErrorMessage.NAME_EXCEED);
            }
        }
    }

    @Override
    public void isCarNameNotBlank(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            if (StringUtils.isBlank(splitCarName)) {
                throw new IllegalArgumentException(ErrorMessage.NAME_NOT_BLANK);
            }
        }
    }

    private boolean isExceedingFive(String splitCarName) {
        return splitCarName.toCharArray().length > Number.MAX_OF_NAMES;
    }
}
