package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {

    private List<Car> cars;

    public Winners(final List<Car> cars) {
        this.cars = cars;
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        for (Car car : this.cars) {
            Name name = car.getName();
            names.add(name.value());
        }
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners = (Winners) o;
        return Objects.equals(cars, winners.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
