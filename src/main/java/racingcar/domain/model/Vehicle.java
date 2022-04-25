package racingcar.domain.model;

public interface Vehicle<T> {
    void move(T n);

    String getName();

    Integer getDistance();

    Integer getTryLimit();
}
