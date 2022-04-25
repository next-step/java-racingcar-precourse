package racingcar.domain;

import racingcar.message.ErrorMessage;
import racingcar.util.ValidationUtils;

public class DistanceDriven {

    private int distanceDriven;

    public DistanceDriven(int distanceDriven) {
        validDistanceDriven(distanceDriven);
        this.distanceDriven = distanceDriven;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public void addDistanceDriven(int addNumber) {
        int sum = this.distanceDriven + addNumber;
        validDistanceDriven(sum);
        this.distanceDriven = sum;
    }

    private void validDistanceDriven(int distanceDriven) {
        if (ValidationUtils.isLessThanMinimum(distanceDriven, 0)) {
            throw new IllegalArgumentException(ErrorMessage.DISTANCE_DRIVEN_ERROR.getMessage());
        }
    }
}
