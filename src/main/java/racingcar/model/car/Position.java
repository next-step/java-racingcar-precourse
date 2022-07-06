package racingcar.model.car;

import racingcar.constant.Message;

public class Position {
    private StringBuilder position;

    public Position() {
        this.position = new StringBuilder("");
    }

    public String getPosition() {
        return position.toString();
    }

    public void move() {
        this.position.append(Message.MOVE);
    }
}
