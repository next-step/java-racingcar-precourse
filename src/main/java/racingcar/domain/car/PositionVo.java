package racingcar.domain.car;

public class PositionVo {
    private final int position;

    public static PositionVo zero() {
        return new PositionVo(0);
    }

    private PositionVo(int position) {
        this.position = position;
    }

    public PositionVo moveOnePosition() {
        return new PositionVo(this.position + 1);
    }

    public int get() {
        return position;
    }
}
