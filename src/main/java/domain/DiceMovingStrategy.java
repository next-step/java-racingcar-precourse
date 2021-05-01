package domain;

public class DiceMovingStrategy implements MovingStrategy {
    public final static int MOVING_POINT = 4;

    @Override
    public void move(Car car) {
        ifDiceOverMovingPointMoveCarOrNot(car, Dice.roll());
    }

    protected void ifDiceOverMovingPointMoveCarOrNot(Car car, Dice dice) {
        if (isDiceTicksOverMovingPoint(dice)) {
            car.move();
        }
    }

    private boolean isDiceTicksOverMovingPoint(Dice dice) {
        return dice.getTicks() >= 4;
    }
}
