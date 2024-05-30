package controller;

import java.util.List;

public class Validation {
    public void isCarNameLengthUnderFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void isCarNameSame(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복되지 않아야 합니다.");
        }
    }

    public void validationCarName(List<String> carNames) {
        carNames.stream().forEach(this::isCarNameLengthUnderFive);
        isCarNameSame(carNames);
    }

    public void isTryCountInteger(String tryCount) {
        tryCount.chars().forEach(c -> {
            if (!Character.isDigit(c)) {
                throw new NumberFormatException("[ERROR] 시도 횟수는 숫자여야 합니다.");
            }
        });
    }

    public void validationTryCount(String tryCount) {
        isTryCountInteger(tryCount);
    }
}
