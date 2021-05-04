package domain.strategy;


import static util.CarRacingConstants.*;

public class RacingCarStrategy implements MovableStrategy {

    private int pos;

    public RacingCarStrategy() {
        this.pos = CAR_START_POS;
    }

    public RacingCarStrategy(int pos) {
        donMoveCauseFullRange(pos);
        this.pos = pos;
    }


    @Override
    public void move(int num) {
        isBetweenZeroAndNine(num);
        donMoveCauseFullRange(pos);
        if (STANDARD_MOVING_NUMBER <= num) {
            pos++;
        }
    }

    @Override
    public int getPos() {
        return pos;
    }

    public static void isBetweenZeroAndNine(int num) {
        if (num < RACING_MOVING_NUMBER_MIN || num > RACING_MOVING_NUMBER_MAX) {
            throw new IllegalArgumentException();
        }
    }

    public void donMoveCauseFullRange(int pos) {
        if (pos >= Integer.MAX_VALUE) {
            throw new IndexOutOfBoundsException();
        }

    }
}
