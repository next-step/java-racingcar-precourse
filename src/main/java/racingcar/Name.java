package racingcar;

public class Name {

    private final String name;

    public Name(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;

        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
