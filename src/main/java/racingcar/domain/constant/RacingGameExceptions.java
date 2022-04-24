package racingcar.domain.constant;

import static racingcar.domain.constant.RacingGameConfiguration.CAR_NAME_MAX_LENGTH;
import static racingcar.domain.constant.RacingGameConfiguration.MAXIMUM_POWER;
import static racingcar.domain.constant.RacingGameConfiguration.MINIMUM_POWER;
import static racingcar.domain.constant.RacingGameConfiguration.MINIMUM_TRY;

public final class RacingGameExceptions {
    public static final String LOCATION_NULL_ERROR = "위치값은 null이 될 수 없습니다.";

    public static final String POWER_NULL_ERROR = "파워는 null이 될 수 없습니다.";
    public static final String MIN_POWER_VALIDATION_ERROR =
            "파워값은 최소 " + MINIMUM_POWER + " 이상의 값만 허용합니다.";
    public static final String MAX_POWER_VALIDATION_ERROR =
            "파워값은 최대 " + MAXIMUM_POWER + " 이하의 값만 허용합니다.";

    public static final String EMPTY_NAME_ERROR = "자동차 이름은 정의되어야 합니다.";
    public static final String NULL_NAME_ERROR = "자동차 이름은 null이 될 수 없습니다.";
    public static final String INVALID_NAME_ERROR = "자동차 이름은 " + CAR_NAME_MAX_LENGTH + "자 이하만 가능합니다.";

    public static final String ACCELERATOR_GENERATOR_NULL_ERROR = "AcceleratorGenerator는 null 값을 가질 수 없습니다.";

    public static final String INVALID_TRY_COUNT_ERROR = "시도 횟수는 최소 " + MINIMUM_TRY + " 이상이어야 합니다.";

    private RacingGameExceptions() {
    }
}
