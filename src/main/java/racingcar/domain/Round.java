package racingcar.domain;

import racingcar.common.Constant;
import racingcar.common.ErrorMessage;

public class Round {
    private final int roundNum;

    public Round(String round) {
        roundValidation(round);
        this.roundNum = Integer.parseInt(round);
    }

    public int getRoundNum() {
        return roundNum;
    }

    private void roundValidation(String round){
        try{
            Integer.parseInt(round);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_ONLY);
        }
        if(Integer.parseInt(round) <= Constant.MIN_ROUND_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.ERROR_ROUND_POSITIVE);
        }
    }
}
