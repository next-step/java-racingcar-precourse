package racing;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

public class CarSet implements Iterable<Car> {
    private final List<Car> set;

    public CarSet(Car... cars) {
        this.set = Arrays.asList(cars);
    }

    public CarSet(List<Car> cars) {
        this.set = cars;
    }

    public int length() {
        return set.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return new CarSetIterator();
    }

    public Car get(int index) {
        return set.get(index);
    }

    public List<Car> getList() {
        return this.set;
    }

    public <T> T reduce(BiFunction<T, Car, T> callback, T initial) {
        T result = initial;
        for (Car car : set) {
            result = callback.apply(result, car);
        }

        return result;
    }

    class CarSetIterator implements Iterator<Car> {
        private int index = 0;

        public boolean hasNext() {
            return index < length();
        }

        public Car next() {
            return get(index++);
        }

    }
}
