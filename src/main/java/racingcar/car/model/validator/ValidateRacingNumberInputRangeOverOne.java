package racingcar.car.model.validator;

import racingcar.car.GameStatus;
import racingcar.car.constant.ErrorMessageConstant;

public class ValidateRacingNumberInputRangeOverOne implements Validator {
    private final int INPUT_LIMIT = 1;

    @Override
    public boolean canValidate(GameStatus gameStatus) {
        return gameStatus == GameStatus.RACING_NUMBER;
    }

    @Override
    public boolean validate(String input) {
        boolean validateResult = true;
        int inputParseInt = Integer.parseInt(input);
        if (inputParseInt < INPUT_LIMIT)
            throw new IllegalArgumentException(ErrorMessageConstant.ERROR_COMMENT_RACING_NUMBER_RANGE);
        return validateResult;
    }
}
