package racingcar.service;

public class CarName {
    private static final int NAME_MAX_SIZE = 5;
    private static final int EMPTY_NAME_SIZE = 0;

    private final String name;

    public CarName(String name) {
        if (name == null || name.length() > NAME_MAX_SIZE || name.length() == EMPTY_NAME_SIZE) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 다시 확인해주세요.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
