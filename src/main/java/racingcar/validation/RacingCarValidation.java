package racingcar.validation;

import racingcar.constant.MessageConst;
import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarConsoleView;
import utils.CommonUtils;
import utils.ValidationUtils;

public class RacingCarValidation {
    public static void validateCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
           if(!ValidationUtils.validateCarName(carNames[i])){
               throw new IllegalArgumentException(MessageConst.ERROR_PREFIX +" " + MessageConst.ERROR_CAR_NAME_LENGTH);
           }
        }
    }

    public static void validateCarCount(String[] carNames) {
        if(!ValidationUtils.validateCarCount(carNames)){
            throw new IllegalArgumentException(MessageConst.ERROR_PREFIX + MessageConst.ERROR_CAR_COUNT);
        }
    }

    public static void validateTryCount(String tryCount) {
        if(!CommonUtils.isNumeric(tryCount)){
            throw new IllegalArgumentException(MessageConst.ERROR_PREFIX + MessageConst.ERROR_NO_NUMERIC);
        }
    }

    public static void validateUniqueCarName(String[] carNames) {
        if(!ValidationUtils.validateUniqueCarName(carNames)){
            throw new IllegalArgumentException(MessageConst.ERROR_PREFIX + MessageConst.ERROR_DUPLICATE_NAME);
        }
    }
}
