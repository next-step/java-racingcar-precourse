package racingcar.car;

import lombok.Getter;

public class Speed {

    public static final int STOP = 3;

    public static final int ADVANCE = 4;
    @Getter
    private int speed;

    public Speed(int speed) {
        this.speed = speed;
    }

    public boolean isStop() {
        if (this.speed <= STOP) {
            return true;
        }
        return false;
    }

    public boolean isAdvance() {
        if (this.speed >= ADVANCE) {
            return true;
        }
        return false;
    }


}
