package racingcar.service;

import racingcar.model.Cars;

public interface ValidateService {

    void validateCarName(Cars cars, String carName);

    void validateCarNameEmpty(String carName);

    void validateCarNameLengthOver(String carName);

    void validateCarNameDuplicate(Cars cars, String carName);

    void validateInputNumber(String inputNumber);
}
