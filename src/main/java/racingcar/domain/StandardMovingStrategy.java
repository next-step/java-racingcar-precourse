package racingcar.domain;

public class StandardMovingStrategy implements MovingStrategy {

    private static final int MOVE_JUDGEMENT_VALUE = 4;

    @Override
    public boolean decide(int number) {
        return MOVE_JUDGEMENT_VALUE <= number;
    }
}
