package racingcar.Model.Racing.Movement;

import racingcar.Util.Constant;

public enum Movement {
    STOP, GO;

    public static Movement move(int pickedNumber) {
        if (pickedNumber >= Constant.BASELINE){
            return GO;
        }

        return STOP;
    }

    public boolean isGo(Movement movement) {
        return movement == GO;
    }
}
