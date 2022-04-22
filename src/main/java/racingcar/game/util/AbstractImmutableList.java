package racingcar.game.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractImmutableList<E> {
    protected final List<E> list;

    protected AbstractImmutableList() {
        list = new ArrayList<>();
    }

    protected AbstractImmutableList(E element) {
        this();
        list.add(element);
    }

    protected AbstractImmutableList(E[] elements) {
        this();
        Collections.addAll(this.list, elements);
    }

    protected AbstractImmutableList(List<E> list) {
        this.list = new ArrayList<>(list);
    }

    protected AbstractImmutableList(List<E> list, E[] elements) {
        this(list);
        Collections.addAll(this.list, elements);
    }

    public E get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public void forEach(Consumer<? super E> action) {
        list.forEach(action);
    }

    public <T> List<T> map(Function<? super E, T> function) {
        List<T> result = new ArrayList<>();
        for (E element: list) {
            result.add(function.apply(element));
        }
        return result;
    }

    /**
     * https://stackoverflow.com/a/53499752/1589451
     */
    public <U> U foldLeft(U identity, BiFunction<U,? super E,U> accumulator) {
        U result = identity;
        for (E element: list) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    public <T extends AbstractImmutableList<?>, S> T mapAndCollect(Function<? super E, S> mapFunction,
                                                                   Function<List<S>, T> collector) {
        return collector.apply(map(mapFunction));
    }
}
