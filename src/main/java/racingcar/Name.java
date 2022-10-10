package racingcar;

public class Name {

    private static final int nameLengthLimit = 5;
    private static final String messageWhenLengthLimitExceeded = "[ERROR]이름은 5자 이하만 가능합니다.";

    private final String name;

    Name(String name) {
        validation(name);
        this.name = name;
    }

    private static void validation(String name) {
        if (name.length() > nameLengthLimit) {
            throw new IllegalArgumentException(messageWhenLengthLimitExceeded);
        }
    }

    String getName() {
        return name;
    }
}
