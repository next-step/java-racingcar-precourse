package domain;

public class CarName {

    public static final String MESSAGE_ERROR_EMPTY_NAME = "[ERROR] 올바른 이름을 입력해주세요.";
    public static final String MESSAGE_ERROR_INVALID_LENGTH_NAME = "[ERROR] 5자 이하의 이름을 입력해주세요.";
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public CarName(String name) {
        if (validate(name)) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public static boolean validate(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_ERROR_EMPTY_NAME);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INVALID_LENGTH_NAME);
        }

        return true;
    }
}
