package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

public class CarName {

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
