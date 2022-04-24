package racingcar.damain;

import racingcar.error.ErrorMessage;
import racingcar.utils.ScannerUtil;

public class TryoutCount {

    private int tryoutCount;

    public TryoutCount(String tryoutCountStr) {
        boolean isValidFail = false;
        while (!isValidFail) {
            try {
                isValidFail = validation(tryoutCountStr);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                tryoutCountStr = ScannerUtil.inputTryoutCount();
                isValidFail = false;
            }
        }
        this.tryoutCount = Integer.parseInt(tryoutCountStr);
    }

    public int getTryoutCount() {
        return tryoutCount;
    }

    private boolean validation(String tryoutCountStr) {
        try {
            Integer.parseInt(tryoutCountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.RaceCountBussinessError.getErrorMsg(), e);
        }
        return true;
    }
}
