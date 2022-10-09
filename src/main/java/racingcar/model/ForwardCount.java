package racingcar.model;

import racingcar.enumeration.CarStatus;

public class ForwardCount {
    private long count;

    public ForwardCount() {
        this.count = 0;
    }

    public void setCountByCarStatus(CarStatus status) {
        if (status.equals(CarStatus.FORWARD)) {
            count += 1;
        }
    }

    public long getCount() {
        return count;
    }
}
