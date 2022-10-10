package racingcar.domain;

import racingcar.util.Constants;
import racingcar.util.RegexUtil;

public class RacingCarName {
    private String name;

    public RacingCarName(String name) {
        validateName(name.trim());
        this.name = name.trim();
    }

    public String toString() {
        return name;
    }

    private void validateName(String name) {
        if (!RegexUtil.match(Constants.REGEX_1_TO_5_CHAR, name)) {
            throw new IllegalArgumentException(Constants.ERR_1_TO_5_CHAR);
        }
    }
}
