package racingcar;

import racingcar.View.View;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Name {
    private static final String INVALID_NAME_ERROR_MESSAGE = "[ERROR] 5자 이하의 값을 입력하세요.";
    private static final int MAX_NAME_SIZE = 5;
    private static final String EMPTY_NAME_ERROR_MESSAGE = "[ERROR] 이름은 1글자 이상의 값을 입력해야 합니다.";
    private static final int MIN_NAME_SIZE = 1;

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_SIZE){
            View.println(INVALID_NAME_ERROR_MESSAGE);
            throw new NoSuchElementException(INVALID_NAME_ERROR_MESSAGE);
        }
        if (name.length() < MIN_NAME_SIZE){
            View.println(EMPTY_NAME_ERROR_MESSAGE);
            throw new NoSuchElementException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
