package racinggame.model;

import racinggame.utils.GameRule;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    List<String> carNames;

    public CarNames(String names) {
        carNames = Arrays.asList(names.split(GameRule.SEPARATOR));
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public boolean isValidCarNames() {
        boolean isValid = true;
        for (String name : carNames) {
            isValid = isValid && name.length() <= GameRule.MAX_CAR_NAME && name.length() >= GameRule.MIN_CAR_NAME;
        }

        return isValid;
    }

}
