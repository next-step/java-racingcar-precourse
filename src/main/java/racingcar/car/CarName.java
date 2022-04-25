package racingcar.car;

import static racingcar.utils.StringUtils.hasNotText;

import java.util.Objects;

public class CarName {
    private String name;

    private CarName(final String name) {
        validateName(name.trim());
        this.name = name.trim();
    }

    public static CarName of(final String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }

    private void validateName(final String name) {
        if (hasNotText(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 없습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 5자가 넘습니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarName)) {
            return false;
        }
        final CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
