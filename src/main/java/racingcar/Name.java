package racingcar;

import java.util.Objects;

public class Name {

    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        validateNameEmpty(name);
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Message.ERROR.message("자동차 이름은 5글자 이하여야 합니다."));
        }
    }

    private void validateNameEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR.message("자동차 이름은 공백일 수 없습니다."));
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name target = (Name) o;
        return name.equals(target.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
