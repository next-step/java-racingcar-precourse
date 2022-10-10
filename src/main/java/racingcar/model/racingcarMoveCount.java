package racingcar.model;

import racingcar.utils.exceptionMessage;

public class racingcarMoveCount {

    private final String moveCount;
    private exceptionMessage message = new exceptionMessage();
    public racingcarMoveCount(String moveCount) {
        checkNumeicMoveCount(moveCount);
        validationcheckMoveCountNegative(moveCount);
        this.moveCount = moveCount;
    }
    public boolean isNumeric(String strMoveCount){
        try {
            Integer.parseInt(strMoveCount);
            return true;
        }catch(IllegalArgumentException e){
            return false;
        }
    }
    public void checkNumeicMoveCount(String strMoveCount){
        if(!isNumeric(strMoveCount))
            throw new IllegalArgumentException(message.inputOnlyNumber());
    }
    public void validationcheckMoveCountNegative(String moveCountStr){
        int moveCountCheck = Integer.parseInt(moveCountStr);
        if(moveCountCheck < 1)
            throw new IllegalArgumentException(message.InputNumNegativeAndUnderZero());
    }
    public String getMoveCount() {
        return moveCount;
    }
}
