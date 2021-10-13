package racinggame.util;

import racinggame.exception.ValidationException;
import java.util.List;

public class Validation {
    public List<String> validateCarName(List<String> racingCars) {
        if (!validateInput(racingCars)) {
            throw new ValidationException();
        }
        return racingCars;
    }

    private boolean validateInput(List<String> racingCars) {
        return racingCars.size() > 0;
    }

}
