package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorCode;

/**
 * Racing 시 사용할 숫자값 Wrapping 클래스
 */
public class RacingNumber {

    private static final int MIN_FORWARD = 4;
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    private final int racingNumber;

    public RacingNumber(int racingNumber) {
        validateRacingNumber(racingNumber);
        this.racingNumber = racingNumber;
    }

    private void validateRacingNumber(int racingNumber) {
        if(racingNumber < MIN_NUM || racingNumber > MAX_NUM) {
            throw new IllegalArgumentException(ErrorCode.전진하는_조건은_0과_9_사이_값.getErrorMessage());
        }
    }

    public boolean isForward() {
        return this.racingNumber >= MIN_FORWARD;
    }

    public static List<RacingNumber> convertToRacingNumber(List<Integer> numbers) {
        List<RacingNumber> racingNumbers = new ArrayList<>();
        for(int number: numbers) {
            racingNumbers.add(new RacingNumber(number));
        }
        return racingNumbers;
    }
}
