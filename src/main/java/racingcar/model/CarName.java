package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.utils.ValidationUtils;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        this.name = getValidName(name);
    }

    private String getValidName(String name) {
        ValidationUtils.validStringThrowIfEmpty(name, ErrorMessage.NAME_IS_REQUIRED);
        ValidationUtils.validConditionThrowIfTrue(
                name.length() > MAX_LENGTH, ErrorMessage.NAME_MUST_BE_FIVE_CHAR_OR_LESS);
        return name;
    }

    public String getName() {
        return name;
    }

}
