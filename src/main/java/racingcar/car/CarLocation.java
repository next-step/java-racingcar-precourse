package racingcar.car;

import java.util.Objects;
import racingcar.utils.NullUtils;

public class CarLocation implements Comparable<CarLocation> {

    private Integer location;

    public CarLocation(Integer location) {
        NullUtils.validNullArgument(location, "CarLocation.location can not be null");
        this.location = location;
    }

    public Integer getLocation() {
        return this.location;
    }

    public void addLocation(int location) {
        this.location += location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarLocation that = (CarLocation) o;
        return Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public int compareTo(CarLocation o) {
        return Integer.compare(this.location, o.location);
    }
}
