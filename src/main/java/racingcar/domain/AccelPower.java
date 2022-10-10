package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class AccelPower {
    public static final int MIN_POWER = 0;
    public static final int MAX_POWER = 9;
    public static final int MIN_POWER_TO_MOVE = 4;
    private int power;

    private AccelPower(int power) {
        validate(power);
        this.power = power;
    }

    public static AccelPower from(int power) {
        return new AccelPower(power);
    }

    public static AccelPower byRandom() {
        int randomPower = Randoms.pickNumberInRange(
                AccelPower.MIN_POWER,
                AccelPower.MAX_POWER
        );

        return from(randomPower);
    }

    public int getPower() {
        return power;
    }

    private void validate(int power) {
        if (power < MIN_POWER || power > MAX_POWER) {
            throw new IllegalArgumentException("악셀은 " + MIN_POWER + "~" + MAX_POWER + "사이의 값만 입력 가능합니다.");
        }
    }

    public boolean isPossibleMove() {
        return this.power >= MIN_POWER_TO_MOVE;
    }
}
