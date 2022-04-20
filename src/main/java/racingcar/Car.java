package racingcar;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final int FORWARD = 4;
    private static final int MAX_POWER = 9;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private int position;
    private String name;

    Car(String name){
        if(name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.position = INIT_POSITION;
        this.name = name;
    }

    public int move(int power) {
        if(this.isForward(power)) return ++position;
        return position;
    }

    private boolean isForward(int power) {
        return FORWARD <= power && MAX_POWER >= power;
    }
}
