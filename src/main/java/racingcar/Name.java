package racingcar;

public class Name {
    private String value;

    public Name(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 값을 허용하지 않습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
