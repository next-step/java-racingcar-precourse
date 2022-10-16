package racingcar.model;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        validationName(name);
        this.name = name;
    }
    public void validationName(String name){
        if (name.length() <= 0 || name.length() >= 6) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 1자 이상 5자 이하로 가능합니다.");
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

    @Override
    public String toString() {
        return this.name;
    }
}
