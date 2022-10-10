package racingcar.domain;

import java.util.Objects;

public class Location {
    public static final int MAX_FORWARD_LIMIT = 9;
    public static final int MIN_FORWARD_LIMIT = 4;
    public static final int MAX_STOP_LIMIT = 3;
    public static final int MIN_STOP_LIMIT = 0;
    public static final String ERROR_MSG_WRONG_NO = "[ERROR] 허용된 범위 밖의 값을 입력하였습니다. 0 ~ 9 의 값을 입력해주세요";

    private int locationValue = 0;

    public Location() {
    }

    public Location(int locationValue) {
        this.locationValue = locationValue;
    }

    public boolean isMovable(int no) {
        validNo(no);
        return no >= MIN_FORWARD_LIMIT && no <= MAX_FORWARD_LIMIT;
    }

    private void validNo(int no) {
        if (no > MAX_FORWARD_LIMIT || no < MIN_STOP_LIMIT) {
            throw new IllegalArgumentException(ERROR_MSG_WRONG_NO);
        }
    }

    public void move() {
        this.locationValue++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return this.locationValue == location.locationValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationValue);
    }

    public int getLocationValue() {
        return locationValue;
    }
}
