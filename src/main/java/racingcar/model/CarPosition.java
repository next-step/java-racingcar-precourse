package racingcar.model;


import racingcar.constant.ConstantNumber;
import racingcar.constant.InfoMessage;

public class CarPosition {
    private Integer position;

    public CarPosition() {
        this.position = 0;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        if (position < 0) {
            throw new IllegalArgumentException(
                    String.format("%s %s is not valid", InfoMessage.ERROR_MESSAGE_BEGIN, position));
        }
        this.position = position;
    }

    public Integer modifyPosition(GameNumber gameNumber) {
        if (gameNumber.getValue() >= ConstantNumber.BORDER_NUMBER) {
            position++;
        }
        return this.position;
    }
}
