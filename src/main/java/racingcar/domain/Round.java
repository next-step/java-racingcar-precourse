package racingcar.domain;

import racingcar.utils.ValidationUtils;
import racingcar.view.InputView;

public class Round {

    private String inputRoundNum;
    private int roundNum;
    private boolean isValidRoundNum;

    public Round() {
        newRoundNum();
    }
    
    private void newRoundNum() {
        do {
            inputRoundNum = InputView.getRoundNumMessage();
            isValidRoundNum = new ValidationUtils(inputRoundNum).isValidRoundNum();
        } while(!isValidRoundNum);

        roundNum = Integer.parseInt(inputRoundNum);
    }

    public int getRoundNum() {
        return roundNum;
    }
}
