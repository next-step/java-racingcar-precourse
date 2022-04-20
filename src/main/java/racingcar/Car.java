package racingcar;

public class Car {

    private final int INIT_POSITION = 0;
    private int position;

    Car(){
        this.position = INIT_POSITION;
    }

    public int move() { return ++position; }
}
