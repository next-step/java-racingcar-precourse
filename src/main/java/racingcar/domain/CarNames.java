package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.ErrorMessage.CAR_NAME_DELIMITER_ERROR_MESSAGE;

public class CarNames {

    private static final String CAR_NAME_DELIMITER = ",";

    private final List<CarName> carNames;

    public CarNames(String carNames) {
        this.carNames = parseCarNames(carNames);
    }

    private List<CarName> parseCarNames(String names) {
        validateCarNamesDelimiter(names);
        List<CarName> carNames = new ArrayList<>();
        String[] split = names.split(CAR_NAME_DELIMITER);
        for (String name : split) {
            carNames.add(new CarName(name));
        }
        return carNames;
    }

    private void validateCarNamesDelimiter(String carNames) {
        if (!carNames.contains(CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException(CAR_NAME_DELIMITER_ERROR_MESSAGE);
        }
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
