package racingcar.model.input.parser;

public class ParseResultValue<T> {
    private final T value;

    public ParseResultValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
