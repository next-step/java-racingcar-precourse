package racingcar.domain.car.carname.validation;

import java.util.ArrayList;
import java.util.List;

public class DuplicateCarNameValidator implements CarNameValidator {

    List<String> carNames = new ArrayList<>();

    @Override
    public void validate(String carName) throws IllegalArgumentException {
        if (carNames.contains(carName)) {
            carNames.clear();
            throw new IllegalArgumentException(ERROR_DUPLICATE_MESSAGE + carName);
        }
        carNames.add(carName);
    }
}
