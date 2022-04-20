package racingcar.game.util;

public abstract class SingleValue<E> {
    protected final E value;

    protected SingleValue(E value) {
        this.value = value;
    }

    public E get() {
        return value;
    }
}
