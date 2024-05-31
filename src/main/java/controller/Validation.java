package controller;

import java.util.List;

public class Validation {
    private void isCarNamesLengthUnderFive(List<String> carNames) {
        carNames.stream().forEach(carName -> {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            }
        });
    }

    private void isCarNameSame(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복되지 않아야 합니다.");
        }
    }

    private void isCarNamesEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 한 명 이상의 참가자가 필요합니다.");
        }
    }

    public boolean validationCarName(List<String> carNames) {
        try {
            isCarNamesLengthUnderFive(carNames);
            isCarNameSame(carNames);
            isCarNamesEmpty(carNames);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void isTryCountPositiveInteger(String tryCount) {
        tryCount.chars().forEach(c -> {
            if (!Character.isDigit(c)) {
                throw new NumberFormatException("[ERROR] 시도 횟수는 양의 정수여야 합니다.");
            }
        });
    }

    private void isTryCountUnderMaximumInteger(String tryCount) {
        if (tryCount.length() > 10 || Long.parseLong(tryCount) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최대 정수값을 초과할 수 없습니다.");
        }
    }

    public boolean validationTryCount(String tryCount) {
        try {
            isTryCountPositiveInteger(tryCount);
            isTryCountUnderMaximumInteger(tryCount);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
