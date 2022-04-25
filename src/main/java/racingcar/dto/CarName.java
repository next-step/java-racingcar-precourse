package racingcar.dto;

public class CarName {
    private final int MIN_NAME_LENGTH = 1;
    private final int MAX_NAME_LENGTH = 5;
    private final String ERROR_MIN_NAME_LENGTH = "[ERROR] 자동차 이름은 1자 이상 입력해주세요.";
    private final String ERROR_MAX_NAME_LENGTH = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";

    private String name;

    public CarName(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MIN_NAME_LENGTH);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MAX_NAME_LENGTH);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
