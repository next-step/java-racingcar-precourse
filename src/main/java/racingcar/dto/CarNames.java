package racingcar.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNames {
    private static final int NAME_MAX_LENGTH = 5;

    private final List<String> values;

    public CarNames(String[] carNames) {
        this.values = Arrays.asList(carNames);
        validateCarNames(carNames);
    }

    private void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차가 하나도 없습니다.");
        }

        if (new HashSet<>(Arrays.asList(carNames)).size() != this.values.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }

        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 비어져있습니다.");
        }
        if (carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 " + NAME_MAX_LENGTH + "자리를 넘어갈 수 없습니다.");
        }
    }

    public List<String> getValues() {
        return values;
    }

}
