package racingcar.Model;

import racingcar.common.Constants;
import racingcar.common.message.ExceptionMessage;
import racingcar.exception.InvalidCarNameLengthException;
import racingcar.view.RacingGameOutputWriter;

public class RacingCarGameValidator {
    RacingGameOutputWriter racingGameOutputWriter;
    boolean validStatus;

    public RacingCarGameValidator() {
        this.racingGameOutputWriter = new RacingGameOutputWriter();
    }

    public void racingCarNamesValidate(String racingCarNames) {
        try {
            checkRacingCarName(racingCarNames);
        } catch (InvalidCarNameLengthException invalidCarNameLengthException) {
            racingGameOutputWriter.answer(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public void checkRacingCarName(String racingCarNames) {
        for (String racingCarName : racingCarNames.split(",")) {
            checkRacingCarNameLength(racingCarName);
        }

        ValidationSuccess();
    }

    public void checkRacingCarNameLength(String racingCarNames) {
        if (racingCarNames.length() > Constants.CAR_NAME_MAXIMUM_LENGTH) {
            throw new InvalidCarNameLengthException(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public boolean isValid() {
        return this.validStatus;
    }

    public void ValidationSuccess() {
        this.validStatus = true;
    }
}
