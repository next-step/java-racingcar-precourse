package racinggame.domain;

import java.security.InvalidParameterException;

public class RacingCount {
    final static String RACING_COUNT_FORMAT_ERROR = "[ERROR] 숫자를 입력 해 주세요.";

    int count;

    public RacingCount() {
        this.count = 0;
    }

    public RacingCount(String count) {
        validateRacingCount(count);
        this.count = Integer.parseInt(count);
    }

    public int getCount() {
        return count;
    }

    private void validateRacingCount(String count){
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e){
            throw new InvalidParameterException(RacingCount.RACING_COUNT_FORMAT_ERROR);
        }
    }
}
