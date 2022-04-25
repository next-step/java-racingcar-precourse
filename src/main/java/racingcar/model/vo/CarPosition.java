package racingcar.model.vo;

import racingcar.constant.GameMessage;
import racingcar.constant.GameRules;

public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void carMove(int forward) {
        if (forward >= GameRules.forwardCondition()) {
            this.position++;
        }
    }

    public String isPosition() {
        StringBuffer isPosition = new StringBuffer();
        for (int i = 0; i < position; i++) {
            isPosition.append("-");
        }
        return isPosition.toString();
    }
}
