package racingcar.domain;


import racingcar.utils.RandomNumber;

public class RacingCarMovingCheck implements MovingCheck {
    private final RandomNumber randomNumber;

    public RacingCarMovingCheck(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMovable() {
        return randomNumber.generator() >= 4;
    }
}
