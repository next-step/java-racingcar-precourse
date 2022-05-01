package racingcar.model.input;

import java.util.Objects;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private static final String EMPTY_ERROR_MESSAGE = String.format("[ERROR] 자동차 이름은 %d자 이상 입력해주세요!", MIN_LENGTH);
    private static final String OVER_LENGTH_ERROR_MESSAGE = String.format("[ERROR] 자동차 이름은 %d자 이하로 입력해주세요!", MAX_LENGTH);

    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        int nameLength = name.length();
        if (nameLength < MIN_LENGTH )
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        if (nameLength > MAX_LENGTH)
            throw new IllegalArgumentException(OVER_LENGTH_ERROR_MESSAGE);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj.getClass() != this.getClass())
            return false;
        return this.name.equals(((CarName) obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
