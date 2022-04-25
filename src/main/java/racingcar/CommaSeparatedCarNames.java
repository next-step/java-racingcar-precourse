package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;

public class CommaSeparatedCarNames implements Iterable<CarName> {
    private ArrayList<CarName> names;

    public CommaSeparatedCarNames() {
        names = new ArrayList<>();
    }

    public CommaSeparatedCarNames(String car_names) {
        names = new ArrayList<>();

        for (String name : car_names.split(",")) {
            names.add(new CarName(name));
        }
    }

    public void append(CarName car_name) {
        names.add(car_name);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");

        for (CarName name : names) {
            joiner.add(name.toString());
        }

        return joiner.toString();
    }

    public CarName get(int index) {
        return names.get(index);
    }

    public int size() {
        return names.size();
    }

    @Override
    public Iterator<CarName> iterator() {
        return new CarNamesIterator();
    }

    class CarNamesIterator implements Iterator<CarName> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public CarName next() {
            CarName current = names.get(index);
            index++;

            return current;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
