package nextstep.domain;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CarName {

    private static final String INVALID_CAR_NAME_MESSAGE = "[ERROR] 자동차 이름은 5글자 이하만 가능합니다.";
    private static final String EMPTY_CAR_NAME_MESSAGE = "[ERROR] 자동차 이름은 빈값이 될 수 없습니다.";
    private static final String DEFAULT_SPLITTER = ",";
    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        checkName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            System.out.println(EMPTY_CAR_NAME_MESSAGE);
            throw new NoSuchElementException(EMPTY_CAR_NAME_MESSAGE);
        }
        if (name.length() > MAX_LENGTH) {
            System.out.println(INVALID_CAR_NAME_MESSAGE);
            throw new NoSuchElementException(INVALID_CAR_NAME_MESSAGE);
        }
    }

    public StringBuilder appendName(StringBuilder sb) {
        return sb.append(name).append(DEFAULT_SPLITTER);
    }
}
