package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public class CarSet extends GeneralIterable<Car> {
    private final List<Car> set;

    public CarSet(Car... cars) {
        this.set = Arrays.asList(cars);
    }

    public CarSet concat(Car car) {
        List<Car> list = new ArrayList<>(set);
        list.add(car);
        return new CarSet(list.toArray(new Car[]{}));
    }

    public String getNames() {
        List<String> names = new ArrayList<>();
        for (Car car : set) {
            names.add(car.getName());
        }
        return String.join(",", names);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public Car get(int index) {
        return set.get(index);
    }

    @Override
    public boolean equals(Object other) {
        return Comparison.Equals(this, other, obj -> obj.set.equals(set));
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    public <T> T reduce(BiFunction<T, Car, T> callback, T initial) {
        T result = initial;
        for (Car car : set) {
            result = callback.apply(result, car);
        }

        return result;
    }
}
