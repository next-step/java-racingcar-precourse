package racingcar.domain;

public class Name {
    public static final String INPUT_ERROR_CAR_NAME = "자동차 이름은 5자리 이하만 가능합니다.";

    private String name;

    public Name(String name) {
        this.name = name;
        isValidCarName(name);
    }

    private void isValidCarName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException(INPUT_ERROR_CAR_NAME);
        }
    }

    public String getNameString() {
        return name;
    }
}
