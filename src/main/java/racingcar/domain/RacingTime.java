package racingcar.domain;

import racingcar.constant.ErrorCode;

/**
 * 레이싱을 진행할 횟수
 */
public class RacingTime {

    private final int racingTime;

    public RacingTime(String time) {
        int racingTime = convertToNumber(time);
        validateRacingTime(racingTime);
        this.racingTime = racingTime;
    }

    private int convertToNumber(String time) {
        try {
            return Integer.parseInt(time);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.입력받은_레이싱_시도_횟수는_숫자.getErrorMessage());
        }
    }

    private void validateRacingTime(int racingTime) {
        if(racingTime < 1) {
            throw new IllegalArgumentException(ErrorCode.레이싱을_시도할_횟수는_0보다_큰_양수.getErrorMessage());
        }
    }

    public int getRacingTime() {
        return racingTime;
    }
}
