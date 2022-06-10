package racingcar.domain.name;

import racingcar.util.StringUtil;

public class Name {

    public String name;

    public Name(String name) {
        this.name = validate(name);
    }

    public String validate(String name) {
        if (StringUtil.isBlank(name)) {
            throw new IllegalArgumentException("[ERROR]: 빈값을 입력할 수 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR]: 이름 입력 범위를 초과하였습니다");
        }
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
