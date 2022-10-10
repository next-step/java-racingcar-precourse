package racingcar.domain;

public class Name {

    private final String name;

    public Name(String name) {
        validationName(name.trim());
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    private void validationName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 입력 값이 유효하지 않습니다.");
        }
    }
}
