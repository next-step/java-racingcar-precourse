package racingcar.domain;

public class Name {

    private static final int NAME_MIN_LENGTH = 5;
    private static final String NAME_ERROR_MESSAGE = "잘못된 이름입니다.";

    private String value;

    public Name(String name) {
        validation(name);
        this.value = name;
    }

    private void validation(String name) {
        if (name.length() > NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }

}
