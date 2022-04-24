package racingcar.model.car;

import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MAX;
import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MIN;
import static racingcar.config.CarMovingConfig.RACING_CAR_MOVING_STANDARD_VALUE;

import racingcar.type.CarMovingStatusType;

public class CarBehavior {

    private final int behaviorNumber;

    public CarBehavior(int behaviorNumber) {
        validate(behaviorNumber);
        this.behaviorNumber = behaviorNumber;
    }

    private void validate(int behaviorNumber) {
        if (RACING_CAR_MOVING_RANGE_VALUE_MIN >= behaviorNumber
            || RACING_CAR_MOVING_RANGE_VALUE_MAX <= behaviorNumber) {
            throw new IllegalArgumentException(
                String.format("추출한 랜덤 숫자는 %d는 %d~%d 사이값 이어야합니다.",
                    behaviorNumber,
                    RACING_CAR_MOVING_RANGE_VALUE_MIN,
                    RACING_CAR_MOVING_RANGE_VALUE_MAX));
        }
    }

    public CarMovingStatusType getMovingStatusType() {
        return behaviorNumber >= RACING_CAR_MOVING_STANDARD_VALUE ?
            CarMovingStatusType.MOVING
            : CarMovingStatusType.NONE;
    }

}
