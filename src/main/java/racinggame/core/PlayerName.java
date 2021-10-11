package racinggame.core;

public class PlayerName {

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public PlayerName(final String name) {
        if (!isValidateName(name)) {
            throw new IllegalArgumentException(
                String.format("이름의 길이는 %d부터 %d까지 가능합니다.", NAME_MIN_LENGTH, NAME_MAX_LENGTH)
            );
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private boolean isValidateName(final String name) {
        return name.length() >= NAME_MIN_LENGTH && name.length() <= NAME_MAX_LENGTH;
    }

}
