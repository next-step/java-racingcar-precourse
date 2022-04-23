package racingcar.model;

public class Car {
    private static final int INIT_MOVE_CNT = 0;

    private Name carName;
    private int moveCnt;

    public Car(String name) {
        this.carName = new Name(name);
        this.moveCnt = INIT_MOVE_CNT;
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public void addMoveCnt() {
        moveCnt++;
    }

    public int getMoveCnt() {
        return moveCnt;
    }
}
