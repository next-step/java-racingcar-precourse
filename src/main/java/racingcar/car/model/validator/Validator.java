package racingcar.car.model.validator;

import racingcar.car.GameStatus;

public interface Validator {

    boolean canValidate(GameStatus gameStatus);

    boolean validate(String input);
}
