package racingcar.Model;

import racingcar.Util.Validation;

public class User {
    private String[] carNameArray;
    private int movingAmount;

    public void setCarNameArray(String carNames) {
        this.carNameArray = convertCarNames(carNames);
    }

    public void setMovingAmount(String movingAmount) {
        this.movingAmount = parseMovingAmount(movingAmount);
    }

    private String[] convertCarNames(String carNames) throws IllegalArgumentException {
        String[] rawNameArray = carNames.split(",");
        for (String carName : rawNameArray) {
            validateCarName(carName);
        }

        return rawNameArray;
    }

    private void validateCarName(String carName) throws IllegalArgumentException {
        if (!Validation.validateCarName(carName)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1-5자여야 한다.");
        }
    }

    private int parseMovingAmount(String movingAmount) throws IllegalArgumentException {
        if (!Validation.validateMovement(movingAmount)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }

        return Integer.parseInt(movingAmount);
    }

    public String[] getCarNameArray() {
        return carNameArray;
    }

    public int getMovingAmount() {
        return movingAmount;
    }
}
