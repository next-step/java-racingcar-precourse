package racingcar.entity;

public class CarPosition {
    private int position;

    private final String STR_ERR_MINUS_MSG = "[ERROR] 입력된 위치값이 음수입니다.";

    public CarPosition(int position) {
        setPosition(position);
    }

    public void setPosition(int pos) {
        checkVaildPosition(pos);
        position = pos;
    }

    public int getPosition() {
        return position;
    }

    private void checkVaildPosition(int pos) {
        if (pos < 0) throw new IllegalArgumentException(STR_ERR_MINUS_MSG);
    }
}
