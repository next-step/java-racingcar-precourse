package racingcar.model;

import racingcar.common.Constants;
import racingcar.common.message.ExceptionMessage;
import racingcar.exception.InvalidCarNameLengthException;
import racingcar.exception.InvalidRacingCarGameRoundsException;

public class RacingCarGameValidator {
    boolean validStatus;

    public RacingCarGameValidator() {
    }

    public void initValidator() {
        this.validStatus = false;
    }

    public void racingCarNamesValidate(String racingCarNames, RacingCarGameError racingCarGameError) {
        try {
            checkRacingCarName(racingCarNames);
        } catch (InvalidCarNameLengthException invalidCarNameLengthException) {
            racingCarGameError.setErrorCode(ExceptionMessage.WRONG_RACING_CAR_NAME_LENGTH_ERROR_CODE);
            racingCarGameError.setDefaultMessage(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public void racingCarGameRoundsValidate(String racingCarGameRounds, RacingCarGameError racingCarGameError) {
        try {
            checkRacingCarGameRounds(racingCarGameRounds);
        } catch (InvalidRacingCarGameRoundsException invalidRacingCarGameRoundsException) {
            racingCarGameError.setErrorCode(ExceptionMessage.WRONG_RACING_CAR_GAME_ROUNDS_ERROR_MESSAGE);
            racingCarGameError.setDefaultMessage(ExceptionMessage.RACING_CAR_GAME_ROUNDS_EXCEPTION_MESSAGE);
        }
    }

    public void checkRacingCarGameRounds(String racingCarGameRounds) {
        for (int i = 0; i < racingCarGameRounds.length(); i++) {
            checkRacingCarGameRoundsIsDigit(racingCarGameRounds, i);
        }

        validationSuccess();
    }

    public void checkRacingCarGameRoundsIsDigit(String racingCarGameRounds, int index) {
        if (!Character.isDigit(racingCarGameRounds.charAt(index))) {
            throw new InvalidRacingCarGameRoundsException(ExceptionMessage.RACING_CAR_GAME_ROUNDS_EXCEPTION_MESSAGE);
        }
    }

    public void checkRacingCarName(String racingCarNames) {
        for (String racingCarName : racingCarNames.split(",")) {
            checkRacingCarNameLength(racingCarName);
        }

        validationSuccess();
    }

    public void checkRacingCarNameLength(String racingCarNames) {
        if (racingCarNames.length() > Constants.CAR_NAME_MAXIMUM_LENGTH) {
            throw new InvalidCarNameLengthException(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public boolean isValid() {
        return this.validStatus;
    }

    public void validationSuccess() {
        this.validStatus = true;
    }
}
