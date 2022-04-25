package racingcar.car;

import java.util.Objects;
import racingcar.utils.StringUtils;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        StringUtils.validEmptyStringArgument(carName, "CarName.carName can not be null");
        this.carName = carName;
    }

    public String name() {
        return this.carName;
    }

    public int length() {
        return this.carName.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
