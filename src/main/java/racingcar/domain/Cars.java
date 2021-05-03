package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Cars {
    private static final String NAME_SEPARATOR = ",";
    private static final String INVALID_MESSAGE = "차량 이름을 5자리 이하로 입력해 주세요.";
    private static final String DUPLICATED_MESSAGE = "차량 이름이 중복되었습니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String userName) {
        this.cars = mapCar(userName);
    }

    private List<Car> mapCar(String userName) {
        List<Car> cars = new ArrayList<>();
        for (String name : userName.split(NAME_SEPARATOR)) {
            Car car = new Car(name);
            validate(cars.contains(car), DUPLICATED_MESSAGE);
            cars.add(car);
        }
        validate(cars.isEmpty(), INVALID_MESSAGE);
        return cars;
    }

    private void validate(boolean invalid, String message) {
        if (invalid) {
            throw new IllegalArgumentException(message);
        }
    }

    public Car get(int index) {
        return this.cars.get(index);
    }

    public int size() {
        return this.cars.size();
    }

    public void forEach(Consumer<Car> action) {
        this.cars.forEach(action);
    }

    public Cars filter(Predicate<Car> predicate) {
        List<Car> newList = new ArrayList<>();
        forEach(car -> filter(newList, car, predicate));
        return new Cars(newList);
    }

    private void filter(List<Car> newList, Car car, Predicate<Car> predicate) {
        if (predicate.test(car)) {
            newList.add(car);
        }
    }

    public void move() {
        forEach(car -> car.move(MoveStatus.getStatus(new RandomNumber())));
    }

    public Cars getWinners() {
        int max = getMaxPosition();
        return filter(car -> car.getPosition() == max);
    }

    private int getMaxPosition() {
        AtomicInteger max = new AtomicInteger();
        forEach(car -> max.set(Math.max(car.getPosition(), max.get())));
        return max.get();
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}