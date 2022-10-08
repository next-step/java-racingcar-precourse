package racingcar.model.car;

import racingcar.exception.MessageMaker;

public class Position {

    private static final String NOT_ALLOW_POSITION = "시작위치는 0 이상이어야 합니다";
    private int position;

    public Position(int position){
        if(position < 0) throw new IllegalArgumentException(MessageMaker.getMessage(NOT_ALLOW_POSITION));
        this.position = position;
    }

    public void go() {
        this.position++;
    }

    public int value() {
        return position;
    }
}
