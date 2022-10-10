package racingcar.model;

import org.junit.platform.commons.util.StringUtils;
import racingcar.message.ExceptionMessage;
import racingcar.exception.InvalidRacingCarNameLengthException;
import racingcar.exception.SpecialCharacterContainException;
import racingcar.utils.PatternUtils;

public class RacingCar {
    private final int MAX_NAME_LENGTH = 5;

    private String name;
    private int position = 0;

    public RacingCar(String carName) throws SpecialCharacterContainException, InvalidRacingCarNameLengthException {
        checkIfContainblankAndSpecialChracter(carName);
        checkIfExceedMaxNameLength(carName);

        this.name = carName;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() { return this.position; }

    public void moveForward() {
        this.position += 1;
    }

    private boolean isValidNameLength(String carName) {
        return carName.length() <= MAX_NAME_LENGTH;
    }

    private void checkIfContainblankAndSpecialChracter(String carName) {
        if (StringUtils.isBlank(carName) || PatternUtils.containSpecialCharacter(carName)) {
            throw new SpecialCharacterContainException(ExceptionMessage.CONTAIN_SPECIAL_CHARACTER_EXCEPTION_MESSAGE);
        }
    }

    private void checkIfExceedMaxNameLength(String carName) {
        if (!isValidNameLength(carName)) {
            throw new InvalidRacingCarNameLengthException(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
