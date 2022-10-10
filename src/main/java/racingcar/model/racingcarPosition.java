package racingcar.model;

import racingcar.utils.exceptionMessage;

public class racingcarPosition {
    private exceptionMessage message = new exceptionMessage();
    private int position;
    private final String Move_position = "-";
    private final int moveCount = 1;
    public racingcarPosition(int position) {
        validationcheckPositionNegative(position);
        this.position = position;
    }
    public void validationcheckPositionNegative(int position){
        if(position < 0)
            throw new IllegalStateException(message.WrongPositionNumber());
    }
    public int getPosition() {
        return position;
    }
     public void move(){
         this.position = position + moveCount;
    }
    @Override
    public String toString() {
        if(position == 0) return "";
        String result = "";
        for(int i=0; i<position; i++){
            result += Move_position;
        }
        return result;
    }

}
