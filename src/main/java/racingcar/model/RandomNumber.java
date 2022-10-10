package racingcar.model;

import static racingcar.constant.RacingCarGameErrorMessage.ERROR_RANDOM_NUMBER_IN_RANGE_ZERO_TO_NINE;

public class RandomNumber {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private final int randomNumber;

    private static final int CAR_FORWARD_MOVE_CONDITION = 4;

    public RandomNumber(int randomNumber) {
        isRandomNumberInRange(randomNumber);
        this.randomNumber = randomNumber;
    }

    public boolean isMovable() {
        return this.randomNumber >= CAR_FORWARD_MOVE_CONDITION;
    }

    private static void isRandomNumberInRange(int random) {
        if (random < MIN_NUM || random > MAX_NUM)
            throw new IllegalArgumentException(ERROR_RANDOM_NUMBER_IN_RANGE_ZERO_TO_NINE);
    }

}
