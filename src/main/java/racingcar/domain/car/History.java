package racingcar.domain.car;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public final class History {

    private final List<Cars> cars;

    private History(Collection<Cars> cars) {
        this.cars = unmodifiableList(new ArrayList<>(cars));
    }

    public static History empty() {
        return new History(new ArrayList<>());
    }

    public History add(Cars cars) {
        List<Cars> newCars = new ArrayList<>(this.cars);
        newCars.add(cars);
        return new History(newCars);
    }

    public List<Cars> cars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        History history = (History) o;
        return Objects.equals(cars, history.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
