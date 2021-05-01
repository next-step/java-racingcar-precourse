package racingcar.domain;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_MESSAGE = "차량 이름을 5자리 이하로 입력해 주세요.";

    private final String name;

    public CarName(String name) {
        if (name == null) {
            throw new NullPointerException(INVALID_NAME_MESSAGE);
        }
        name = name.trim();
        if ("".equals(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
