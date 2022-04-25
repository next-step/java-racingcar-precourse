package racingcar.domain;

import racingcar.constant.ErrorMessageConst;

public class RacingCarName {
    public static final int VALUE_CARNAME_MIN = 1;
    public static final int VALUE_CARNAME_MAX = 5;

    private String name;

    public RacingCarName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_NULL);
        }
        if(name.length() > VALUE_CARNAME_MAX || name.length() < VALUE_CARNAME_MIN){
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT,
                            VALUE_CARNAME_MIN, VALUE_CARNAME_MAX)
            );
        }
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
