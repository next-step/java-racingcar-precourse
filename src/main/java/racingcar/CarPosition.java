package racingcar;

public class CarPosition {

    private int curPosition;

    public CarPosition() {
        this.curPosition = 0;
    }

    public int getCurPosition() {
        return curPosition;
    }

    public void increaseCurPosition() {
        curPosition++;
    }
}
