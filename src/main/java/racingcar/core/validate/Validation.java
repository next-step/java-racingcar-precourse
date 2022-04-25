package racingcar.core.validate;

import racingcar.core.exception.ValidationException;

import java.util.List;

public class Validation {

    private static final String ERROR_INPUT_SIZE = "[ERROR] 최소 하나 이상의 자동차 이름을 입력하셔야 됩니다.";

    private static final String ERROR_INPUT_NAME = "[ERROR] 자동차의 이름은 5글자 이하여야 됩니다.";

    private static final String ERROR_INPUT_ROUND = "[ERROR] 회수는 0~9까지의 숫자로 입력하셔야 됩니다.";

    public List<String> validateList(List<String> racingCars) {
        if (!validateInput(racingCars)) {
            throw new ValidationException(ERROR_INPUT_SIZE);
        }
        return racingCars;
    }

    private boolean validateInput(List<String> racingCars) {
        return racingCars.size() > 0;
    }

    public String validateName(String carName) {
        if (!carName.matches("^[\\w]{1,5}$")) {
            throw new ValidationException(ERROR_INPUT_NAME);
        }
        return carName;
    }

    public int validateRound(String round) {
        if (!round.matches("^[0-9]{1}$")) {
            throw new ValidationException(ERROR_INPUT_ROUND);
        }
        return Integer.parseInt(round);
    }
}
