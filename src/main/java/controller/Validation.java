package controller;

import java.util.List;

public class Validation {
    public void isCarNamesLengthUnderFive(List<String> carNames) {
        carNames.stream().forEach(carName -> {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            }
        });
    }

    public void isCarNameSame(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복되지 않아야 합니다.");
        }
    }

    public void isCarNamesEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 한 명 이상의 참가자가 필요합니다.");
        }
    }

    public void validationCarName(List<String> carNames) {
        isCarNamesLengthUnderFive(carNames);
        isCarNameSame(carNames);
        isCarNamesEmpty(carNames);
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
