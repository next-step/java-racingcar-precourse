package racingcar.domain;

import java.util.HashSet;
import java.util.Set;

import static racingcar.view.ErrorMessage.*;

public class CarNames {

    public static final String COMMA = ",";

    private final String[] carNames;

    public CarNames(String names) {
        this.carNames = names.split(COMMA);
        checkEmpty();
        trim();
        checkDuplicates();
    }

    private void checkEmpty() {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(DEFAULT.getMessage() + NOT_ENTER_COMMAS.getMessage());
        }
    }

    private void trim() {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private void checkDuplicates() {
        Set<String> set = new HashSet<>();
        for (String name : carNames) {
            set.add(name.trim());
        }

        if (set.size() != carNames.length) {
            throw new IllegalArgumentException(DEFAULT.getMessage() + DUPLICATE_NAME.getMessage());
        }
    }

    public String[] getCarNames() {
        return carNames;
    }
}
