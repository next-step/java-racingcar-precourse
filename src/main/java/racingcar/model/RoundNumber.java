package racingcar.model;

import static racingcar.constant.ErrorMessage.RACING_ROUND_MUST_NUMBER;

public class RoundNumber {

    private int number;

    public void initRoundNumber(String number) {
        if (!isNumberic(number)) {
            throw new IllegalArgumentException(RACING_ROUND_MUST_NUMBER);
        }
        this.number = Integer.parseInt(number);
    }

    private boolean isNumberic(String roundNumber) {
        return roundNumber != null && roundNumber.matches("[-+]?\\d*\\.?\\d+");
    }

    public int getRoundNumber() {
        return number;
    }
}
