package racingcar.car.value;

import racingcar.common.exception.ErrorMessage;

public class Position {
    private int position;

    public Position(){
        this.position = 0;
    }

    public Position(int position) {
        validation(position);
        this.position = position;
    }

    private void validation(int position){
        if(position < 0){
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_NEGATIVE.getMessage());
        }
    }

    public int position() {
        return position;
    }

    public void move(){
        this.position++;
    }
}
