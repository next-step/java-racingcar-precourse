package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import racingcar.ExceptionMessageUtils;

public final class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private static void validateCars(final List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createExceptionMessage("cars cannot be null"));
        }
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createExceptionMessage("cars cannot be empty"));
        }
        if (cars.contains(null)) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createExceptionMessage("cars cannot contain null object"));
        }
    }

    // Note : private하고 static하게 접근제한을 위해, Comparator Interface 구현하지 않고, Method signature만을 맞췄습니다.
    private static int compareCarByDistance(final Car car1, final Car car2) {
        if (car1.isFartherMovedThan(car2)) {
            return -1;
        }
        if (car1.isLessMovedThan(car2)) {
            return 1;
        }
        return 0;
    }

    private static <T> void addToListIfMatched(
        final List<T> list,
        final T item,
        final Predicate<T> predicate
    ) {
        if (predicate.test(item)) {
            list.add(item);
        }
    }

    private static <T> List<T> filter(final List<T> list, final Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T item : list) {
            addToListIfMatched(result, item, predicate);
        }
        return result;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        // Note : 자동차 개체 상태 변경 방지를 위해 immutable list 반환
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getFarthestMovedCars() {
        final Car farthestMovedCar = getFarthestMovedCar();
        // Note : 자동차 개체 상태 변경 방지를 위해 immutable list 반환
        return Collections.unmodifiableList(filter(cars, farthestMovedCar::isSamelyMovedWith));
    }

    private Car getFarthestMovedCar() {
        final List<Car> tmp = new ArrayList<>(cars);
        tmp.sort(Cars::compareCarByDistance);
        // Note : 생성된 cars는 always non-null, non-empty, not contains null
        return tmp.get(0);
    }

}
