package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CarSet implements Iterable<Car> {
    private List<Car> set;

    public CarSet() {
        this.set = new ArrayList<>();
    }

    public CarSet(Car... cars) {
        this.set = Arrays.asList(cars);
    }

    public int length() {
        return set.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return new CarSetIterator();
    }

    private Car get(int index) {
        return set.get(index);
    }

    class CarSetIterator implements Iterator<Car> {
        private int index = 0;
        private int round;

        public boolean hasNext() {
            return index < length();
        }

        public Car next() {
            return get(index++);
        }

    }
}
