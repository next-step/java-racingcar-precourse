package camp.nextstep.edu.wrapper;

import camp.nextstep.edu.constant.Message;

public class RacingCarPosition {

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(Message.INVALID_POSITION);
        }
        this.position = position;
    }
}
