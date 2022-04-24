package racingcar.model;

public class CarMovableStrategy implements MovableStrategy {

    private static final int MOVE_CONDITION_NUM = 4;

    @Override
    public boolean isMovable() {
        return RandomNumber.generate() >= MOVE_CONDITION_NUM;
    }

}
