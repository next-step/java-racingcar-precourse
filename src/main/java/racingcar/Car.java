package racingcar;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final int FORWARD = 4;
    private static final int MAX_POWER = 9;

    private int position;

    Car(){
        this.position = INIT_POSITION;
    }

    public int move(int power) {
        if(this.isForward(power)) return ++position;
        return position;
    }

    private boolean isForward(int power) {
        return FORWARD <= power && MAX_POWER >= power;
    }
}
