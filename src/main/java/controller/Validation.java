package controller;

import java.util.List;

public class Validation {

    private void isCarNameUnderFive(List<String> carNames) {
        carNames.forEach(carName -> {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            }
        });
    }

    private void isTryCountInt(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private void isTryCountPositive(String tryCount) {
        int count = Integer.parseInt(tryCount);
        if (count <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 커야 합니다.");
        }
    }

    private boolean validate(Runnable logic) {
        try {
            logic.run();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validationCarName(List<String> carNames) {
        return validate(() -> isCarNameUnderFive(carNames));
    }

    public boolean validationTryCount(String tryCount) {
        return validate(() -> {
            isTryCountInt(tryCount);
            isTryCountPositive(tryCount);
        });
    }

}
