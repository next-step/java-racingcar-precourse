package racingcar.service.impl;

import racingcar.constant.ErrorMessage;
import racingcar.constant.GameRules;
import racingcar.model.Cars;
import racingcar.service.ValidateService;

public class ValidateServiceImpl implements ValidateService {

    @Override
    public void validateCarName(Cars cars, String carName) {
        validateCarNameEmpty(carName);
        validateCarNameLengthOver(carName);
        validateCarNameDuplicate(cars, carName);
    }

    @Override
    public void validateCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_EMPTY_NAME.getMessage());
        }
    }

    @Override
    public void validateCarNameLengthOver(String carName) {
        if (carName.length() > GameRules.carNameLength()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_LENGTH_OVER.getMessage());
        }
    }

    @Override
    public void validateCarNameDuplicate(Cars cars, String carName) {
        if (cars.getListCarName().contains(carName)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_DUPLICATE.getMessage());
        }
    }

    @Override
    public void validateInputNumber(String inputNumber) {
        if (!inputNumber.matches("^[0-9]*?")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NUMBER.getMessage());
        }
    }
}