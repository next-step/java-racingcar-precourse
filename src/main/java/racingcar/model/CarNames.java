package racingcar.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {
    private static final String DELIMITER = ",";
    private final String names;

    public CarNames(String names) {
        if (!isValidNames(names)) {
            throw new IllegalArgumentException("유효하지 않은 이름이 있습니다. names=" + names);
        }
        this.names = names;
    }

    private boolean isValidNames(String names) {
        if (names == null) {
            return false;
        }
        if (!names.contains(DELIMITER)) {
            return false;
        }
        String[] carNames = names.split(DELIMITER);
        if (carNames.length < 2) {
            return false;
        }
        if (containsBlankName(carNames)) {
            return false;
        }
        if (containsDuplicatedName(carNames)) {
            return false;
        }
        return true;
    }

    private boolean containsDuplicatedName(String[] carNames) {
        Set<String> set = new HashSet<>(Arrays.asList(carNames));
        return set.size() != carNames.length;
    }

    private boolean containsBlankName(String[] carNames) {
        boolean contains = false;
        for (String carName : carNames) {
            boolean blankName = isBlankName(carName);
            contains = contains || blankName;
        }
        return contains;
    }

    private boolean isBlankName(String carName) {
        return carName == null || carName.trim().isEmpty();
    }

    public List<String> getCarNames() {
        return Arrays.asList(this.names.split(DELIMITER));
    }

}
