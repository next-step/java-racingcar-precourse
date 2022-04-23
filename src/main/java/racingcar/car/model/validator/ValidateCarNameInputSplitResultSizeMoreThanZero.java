package racingcar.car.model.validator;

import racingcar.car.GameStatus;
import racingcar.car.constant.Constant;
import racingcar.car.constant.ErrorMessageConstant;

public class ValidateCarNameInputSplitResultSizeMoreThanZero implements Validator {

    @Override
    public boolean canValidate(GameStatus gameStatus) {
        return gameStatus == GameStatus.CAR_NAME;
    }

    @Override
    public boolean validate(String input) {
        boolean validateResult = true;
        String[] names = input.trim().split(Constant.CAR_NAMES_DELIMITER);
        if (names.length == 0)
            throw new IllegalArgumentException(ErrorMessageConstant.ERROR_COMMENT_CAR_NAME_COUNT);
        return validateResult;
    }
}

