package racingcar.model;

import racingcar.function.RandomNumberProvider;

public class Drive {
    public static final int MOVE_DECIDE_STANDARD_NUMBER = 4;
    public static final int MOVE_POINT = 1;
    public static final int STOP_POINT = 0;

    private final RandomNumberProvider randomNumberProvider;

    public Drive(RandomNumberProvider randomNumberProvider) {
        this.randomNumberProvider = randomNumberProvider;
    }

    public int move() {
        int randomNumber = this.randomNumberProvider.generateNumber();
        if (randomNumber >= MOVE_DECIDE_STANDARD_NUMBER) {
            return MOVE_POINT;
        }
        return STOP_POINT;
    }
}
