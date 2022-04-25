package racingcar.domain;



public class CarNames {
    private final String[] carNames;

    public CarNames(String[] carNames) {
        trimStr(carNames);
        validateLength(carNames);
        this.carNames = carNames;

    }

    private void trimStr(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private void validateLength(String[] carNames) {
        for (String carName : carNames) {
            validateLength(carName);
        }
    }

    private void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public String[] getCarNameList() {
        return carNames;
    }
}
