package racinggame.view;

import nextstep.utils.Console;

import static racinggame.common.Constant.*;
import static racinggame.common.ValidationUtils.validCarNames;
import static racinggame.common.ValidationUtils.validTryNo;

public class RacingView {

    public void printInputCarsName() {
        System.out.println(INPUT_CARS_NAME);
    }

    public String inputCarsName() {
        String carsName = Console.readLine();
        if(!validCarNames(carsName)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERR_CAR_MIN_NUM);
        }
        return carsName;
    }

    public void printInputTryNumber() {
        System.out.println(INPUT_TRY_NUMBER);
    }

    public int inputTryNumber() {
        String tryNo = Console.readLine();
        if(!validTryNo(tryNo)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERR_TRY_NO);
        }
        return Integer.parseInt(tryNo);
    }

    public void printPlayResult() {
        System.out.println(PLAY_RESULT);
    }

    public void printGoStatus(int score) {
        for(int i = 0; i < score; i++) {
            System.out.print(GO_STATUS);
        }
        System.out.println();
    }
}
