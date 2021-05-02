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
}
