package racingcar.domain;

public class CarName {
    private static final String ILLEGAL_ARGUMENT_NAME = "[ERROR] 이름은 공백이 불가능합니다.";
    private static final String ILLEGAL_ARGUMENT_MAX_SIZE = "[ERROR] 이름은 최대 길이 %d를 넘을 수 없습니다.";
    private static final int MAX_SIZE = 5;
    private String name;

    public CarName(String name) {
        String trimName = name.trim();
        isValid(trimName);
        this.name = trimName;
    }

    public void isValid(String name) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_NAME);
        }

        if (isGtMaxSize(name)) {
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_MAX_SIZE, MAX_SIZE));
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isNullOrEmpty(String name) {
        return name != null && !name.isEmpty() ? false : true;
    }

    public boolean isGtMaxSize(String name) {
        return name.length() > MAX_SIZE ? true : false;
    }
}
