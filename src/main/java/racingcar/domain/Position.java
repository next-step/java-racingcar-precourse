package racingcar.domain;

import racingcar.common.Constant;
import racingcar.enums.Action;

public class Position {
    private int carPosition;

    public Position(int carPosition) {
        isNonNegativePosition(carPosition);
        this.carPosition = carPosition;
    }

    public void setCarPosition(int carPosition) {
        this.carPosition = carPosition;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public void addCarPosition(Action action){
        if(isMoving(action)){
            carPosition++;
        }
    }

    private boolean isMoving(Action action){
        return action == Action.MOVE;
    }

    private void isNonNegativePosition(int carPosition){
        if(carPosition < Constant.MIN_POSITION_NUMBER){
            throw new IllegalStateException();
        }
    }
}
