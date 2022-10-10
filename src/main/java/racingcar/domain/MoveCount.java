package racingcar.domain;

import static racingcar.Constants.ErrorMessage.MOVE_COUNT_VALID_ERR_MSG;

public class MoveCount {
    private final int moveCount;

    public MoveCount(String moveCount){
        validateNull(moveCount);
        validateNumberFormat(moveCount);
        this.moveCount = Integer.parseInt(moveCount);
        validateNumber(this.moveCount);
    }

    public static void validateNull(String moveCount){
        if(moveCount == null || moveCount.isEmpty()){
            throw new IllegalArgumentException(MOVE_COUNT_VALID_ERR_MSG);
        }
    }

    private static void validateNumberFormat(String moveCount){
        try {
            Integer.parseInt(moveCount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(MOVE_COUNT_VALID_ERR_MSG);
        }
    }

    private void validateNumber(int moveCount){
        if(moveCount < 1){
            throw new IllegalArgumentException(MOVE_COUNT_VALID_ERR_MSG);
        }
    }

    public int getMoveCount(){
        return moveCount;
    }
}
