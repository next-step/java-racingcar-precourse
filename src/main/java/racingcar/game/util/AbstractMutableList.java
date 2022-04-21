package racingcar.game.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractMutableList<E> {
    protected final List<E> list;

    protected AbstractMutableList() {
        list = new ArrayList<>();
    }

    protected AbstractMutableList(E element) {
        this();
        list.add(element);
    }

    protected AbstractMutableList(List<E> list) {
        this.list = list;
    }

    protected AbstractMutableList(List<E> list, E[] elements) {
        this(list);
        Collections.addAll(this.list, elements);
    }

    public boolean add(E element) {
        return list.add(element);
    }

    public int size() {
        return list.size();
    }

    public void forEach(Consumer<? super E> action) {
        list.forEach(action);
    }

    public <T> List<T> map(Function<E, T> function) {
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

    public <T extends AbstractMutableList<?>, S> T mapAndCollect(Function<E, S> mapFunction,
                                                                 Function<List<S>, T> accumulator) {
        return accumulator.apply(map(mapFunction));
    }
}
