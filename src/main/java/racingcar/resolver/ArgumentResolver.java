package racingcar.resolver;

public interface ArgumentResolver<T> {
    public T convert(String input);
}
