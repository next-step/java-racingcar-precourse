package racingcar.model.racing;

import racingcar.constant.ErrorMessage;
import racingcar.model.car.CarConfig;

public class LapCount {
    private final int count;

    public LapCount(String value) {
        this.count = parseInt(value);
    }

    private int parseInt(String value) {
        validate(value);

        return Integer.parseInt(value);
    }

    private void validate(String value) {
        try {
            int lapCount = Integer.parseInt(value);

            if (lapCount < CarConfig.MIN_LAP_COUNT) {
                throw new NumberFormatException();
            }
        } catch (NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_CAR_RACING_COUNT_RANGE, CarConfig.MIN_LAP_COUNT,
                                  Integer.MAX_VALUE));
        }
    }

    public int getLapCount() {
        return count;
    }
}
