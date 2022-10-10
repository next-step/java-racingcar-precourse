package racingcar.car.domain;

public class MoveStrategy {

    private static final int MOVABLE_MINIMUM_NUMBER = 4;
    private static final int MOVABLE_MAXIMUM_NUMBER = 9;

    public boolean movable(int randomNumber) {
        return randomNumber >= MOVABLE_MINIMUM_NUMBER && randomNumber <= MOVABLE_MAXIMUM_NUMBER;
    }
}
