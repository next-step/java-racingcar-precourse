package racingcar.car;

import java.util.Objects;

public class RacingCarName {
    private static final int RACING_CAR_NAME_MAX_LENGTH = 5;
    private static final String RACING_CAR_NAME_LENGTH_LIMIT_MESSAGE =
            "이름은 " + RACING_CAR_NAME_MAX_LENGTH + "자까지만 허용됩니다.";
    private static final String RACING_CAR_NAME_EMPTY_MESSAGE = "자동차이름을 빈 값으로 설정할 수 없습니다.";

    private final String name;

    public RacingCarName(String name) {
        if (name.length() > RACING_CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(RACING_CAR_NAME_LENGTH_LIMIT_MESSAGE);
        }
        if (name == null || "".equals(name)) {
            throw new IllegalArgumentException(RACING_CAR_NAME_EMPTY_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCarName that = (RacingCarName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
