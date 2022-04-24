package racingcar.model;

import racingcar.common.Constants;
import racingcar.common.message.ExceptionMessage;
import racingcar.exception.InvalidCarNameLengthException;
import racingcar.exception.InvalidRacingCarGameRoundsException;
import racingcar.view.RacingGameOutputWriter;

public class RacingCarGameValidator {
    RacingGameOutputWriter racingGameOutputWriter;
    boolean validStatus;

    public RacingCarGameValidator() {
        this.racingGameOutputWriter = new RacingGameOutputWriter();
    }

    public void initValidator() {
        this.validStatus = false;
    }

    public void racingCarNamesValidate(String racingCarNames) {
        try {
            checkRacingCarName(racingCarNames);
        } catch (InvalidCarNameLengthException invalidCarNameLengthException) {
            racingGameOutputWriter.answer(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public void racingCarGameRoundsValidate(String racingCarGameRounds) {
        try {
            checkRacingCarGameRounds(racingCarGameRounds);
        } catch (InvalidRacingCarGameRoundsException invalidRacingCarGameRoundsException) {
            racingGameOutputWriter.answer(ExceptionMessage.RACING_CAR_GAME_ROUNDS_EXCEPTION_MESSAGE);
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
