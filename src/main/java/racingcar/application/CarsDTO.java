package racingcar.application;

public class CarsDTO {
    private static final String SPLIT_REGEX = ",";
    private static final String ERROR_MESSAGE = "잘못된 형식입니다.";

    String carNames;

    public CarsDTO(String carNames) {
        validation(carNames);
        this.carNames = carNames;
    }

    public String[] toCarNames() {
        return this.carNames.split(SPLIT_REGEX);
    }

    public void validation(String carNames) {
        if (carNames == null || !carNames.contains(SPLIT_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
