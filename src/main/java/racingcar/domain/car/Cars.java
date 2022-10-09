package racingcar.domain.car;

import racingcar.domain.move.Move;
import racingcar.util.StringCommaAppender;

import java.util.*;
import java.util.function.Consumer;

public class Cars implements Iterable<Car> {

    private final List<Car> cars = new ArrayList<>();

    public Cars(CarNames carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public String getNames() {
        StringCommaAppender appender = new StringCommaAppender("");
        for (Car car : this.cars) {
            appender.append(car.getName());
        }
        return appender.get();
    }

    public void move(Move move) {
        for (Car car : cars) {
            car.move(move);
        }
    }

    public void sort() {
        Collections.sort(cars);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    @Override
    public void forEach(Consumer<? super Car> action) {
        cars.forEach(action);
    }

    @Override
    public Spliterator<Car> spliterator() {
        return cars.spliterator();
    }
}
