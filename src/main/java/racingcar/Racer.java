package racingcar;

/**
 * @author SeongRok.Oh
 * @since 2022/10/10
 */
public class Racer {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    private Racer(String name) {
        validateName(name);
        this.name = name;
    }

    public static Racer from(String name) {
        return new Racer(name);
    }

    private void validateName(String name) {
        if (isOverLengthName(name)) {
            throw new IllegalArgumentException(PrintMessage.NAME_OUT_OF_LENGTH_ERROR.getMessage());
        }
        if (isEmptyName(name)) {
            throw new IllegalArgumentException(PrintMessage.NAME_EMPTY_ERROR.getMessage());
        }
    }

    private boolean isOverLengthName(String name) {
        return name.length() > NAME_MAX_LENGTH;
    }

    private boolean isEmptyName(String name) {
        return name.isEmpty();
    }

    public String getName() {
        return name;
    }
}
