package racingcar.constant;

import static racingcar.constant.GameEnvironment.MAX_NAME_SIZE;
import static racingcar.constant.GameEnvironment.MIN_NAME_SIZE;
import static racingcar.constant.GameEnvironment.MIN_RACE_COUNT;

public class ErrorMessage {
    private static final String ERROR_PREFIX = "[ERROR]";

    public static final String INVALID_CAR_NAME =
            String.format("%s 자동차 이름은 %d ~ %d자로 입력해야 합니다.", ERROR_PREFIX, MIN_NAME_SIZE, MAX_NAME_SIZE);

    public static final String DUPLICATED_CAR_NAME =
            String.format("%s 자동차 이름은 중복될 수 없습니다.", ERROR_PREFIX);

    public static final String INVALID_RACE_COUNT_FORMAT =
            String.format("%s 시도 횟수는 숫자여야 합니다.", ERROR_PREFIX);

    public static final String INVALID_RACE_COUNT_RANGE =
            String.format("%s 시도 횟수는 %d 이상이어야 합니다.", ERROR_PREFIX, MIN_RACE_COUNT);
}
