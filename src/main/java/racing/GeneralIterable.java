package racing;

import java.util.Iterator;

public abstract class GeneralIterable<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    public abstract int size();

    public abstract T get(int index);

    class InnerIterator implements Iterator<T> {
        private int index = 0;

        public boolean hasNext() {
            return index < size();
        }

        public T next() {
            return get(index++);
        }
    }
}
