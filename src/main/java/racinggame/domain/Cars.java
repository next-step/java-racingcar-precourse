package racinggame.domain;

import racinggame.domain.strategy.MoveStrategy;

import java.util.*;

public class Cars {

    private static final String NAME_SPLIT_REGEX = ",";
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Cars(final Cars cars) {
        this(cars.cars);
    }

    public Cars(final String names) {
        this(initCars(names));
    }

    private static List<Car> initCars(final String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names.split(NAME_SPLIT_REGEX)) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void move(final MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> elements() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> winners() {
        List<Car> cars = new ArrayList<>();
        for (Car car : this.cars) {
            cars = mergeIfMaxDistanceIsEqual(cars, car);
        }
        return Collections.unmodifiableList(cars);
    }

    private List<Car> mergeIfMaxDistanceIsEqual(final List<Car> cars, final Car car) {
        Distance distance = car.getDistance();
        Distance maxDistance = max();

        if (distance.equals(maxDistance)) {
            return merge(cars, car);
        }

        return new ArrayList<>();
    }

    private Distance max() {
        LinkedList<Distance> distances = mapToDistance();
        Collections.sort(distances);
        return distances.getLast();
    }

    private LinkedList<Distance> mapToDistance() {
        LinkedList<Distance> distances = new LinkedList<>();
        for (Car car : this.cars) {
            Distance distance = car.getDistance();
            distances.add(distance);
        }
        return distances;
    }

    private List<Car> merge(final List<Car> cars, final Car car) {
        List<Car> list = new ArrayList<>();
        list.addAll(cars);
        list.addAll(Collections.singletonList(car));
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
