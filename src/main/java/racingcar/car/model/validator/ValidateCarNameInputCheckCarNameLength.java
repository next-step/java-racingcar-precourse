package racingcar.car.model.validator;

import racingcar.car.GameStatus;
import racingcar.car.constant.Constant;
import racingcar.car.constant.ErrorMessageConstant;

public class ValidateCarNameInputCheckCarNameLength implements Validator {
    private final int NAME_MAX_LENGTH = 5;
    private final int NAME_MIN_LENGTH = 1;

    @Override
    public boolean canValidate(GameStatus gameStatus) {
        return gameStatus == GameStatus.CAR_NAME;
    }

    @Override
    public boolean validate(String input) {
        boolean validateResult = true;
        String[] names = input.split(Constant.CAR_NAMES_DELIMITER);
        for (int i = 0; i < names.length && validateResult; i++) {
            validateResult = validateResult && validateNameLength(names[i]);
        }
        if (validateResult == false)
            throw new IllegalArgumentException(ErrorMessageConstant.ERROR_COMMENT_CAR_NAME_LENGTH);
        return validateResult;
    }

    private boolean validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            return false;
        }
        return true;
    }


}

