package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class JudgmentNumber {

    public static final int MOVE_CONDITION_NUMBER = 4; 
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private final int number;

    private JudgmentNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static JudgmentNumber from(int number) {
        return new JudgmentNumber(number);
    }

    public static JudgmentNumber newJudgmentNumber() {
        return new JudgmentNumber(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
    }

    public boolean canMove() {
        return (number >= MOVE_CONDITION_NUMBER);
    }

    private void validate(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(
                    ErrorMessage.OUT_OF_RANGE_NUMBER_ERROR.getMessage(MIN_NUMBER, MAX_NUMBER));
        }
    }

    private boolean isValidRange(int number) {
        return (number >= MIN_NUMBER && number <= MAX_NUMBER);  
    }
}
