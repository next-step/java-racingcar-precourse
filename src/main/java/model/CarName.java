package model;

public class CarName {

    private static final int NAME_LENGTH_UPPER_BOUND = 5;

    private final String carName;

    public CarName(String carName) {
        validateBlank(carName);
        validateLength(carName);
        validateAlphabet(carName);
        this.carName = carName;
    }

    private void validateBlank(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 null 이거나 빈 문자열일 수 없습니다.");
        }
    }

    public void validateLength(String carName) {
        if (carName.length() > NAME_LENGTH_UPPER_BOUND) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void validateAlphabet(String carName) {
        for (char c : carName.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 영문으로만 이루어질 수 있습니다.");
            }
        }
    }

    public String getCarName() {
        return carName;
    }
}