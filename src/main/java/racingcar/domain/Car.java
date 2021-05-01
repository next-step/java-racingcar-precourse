package racingcar.domain;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_INVALID_MESSAGE = "차량 이름을 5자리 이하로 입력해 주세요.";
    private final String name;

    public Car(String name) {
        this.name = validateName(name);
    }

    private static String validateName(String name) {
        if (name == null) {
            throw new NullPointerException(NAME_INVALID_MESSAGE);
        }
        name = name.trim();
        if ("".equals(name) || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_INVALID_MESSAGE);
        }
        return name;
    }

    public String getName() {
        return name;
    }
}
