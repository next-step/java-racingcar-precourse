package racingcar.domain.car;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import racingcar.domain.car.vo.Name;
import racingcar.domain.car.vo.Position;
import racingcar.domain.policy.MovePolicy;

public final class Cars {

    private List<Car> content;

    public Cars(Collection<Car> cars) {
        validationSize(cars);
        this.content = unmodifiableList(new ArrayList<>(cars));
    }

    public static Cars from(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            cars.add(new Car(new Name(carName), Position.zero()));
        }
        return new Cars(cars);
    }

    public Cars move(MovePolicy movePolicy) {
        final List<Car> cars = new ArrayList<>();
        for (final Car currentCar : content) {
            cars.add(moveAndStay(movePolicy, currentCar));
        }
        return new Cars(cars);
    }

    public Cars winners() {
        final Position maxPosition = findMaxPositionValue();
        final List<Car> winners = new ArrayList<>();

        for (Car car : content) {
            addWinnerCar(winners, car, maxPosition);
        }
        return new Cars(winners);
    }

    public List<Car> cars() {
        return content;
    }

    public List<String> carNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : content) {
            carNames.add(car.nameValue());
        }
        return carNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars = (Cars) o;
        return Objects.equals(content, cars.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    private void validationSize(Collection<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 차가 최소 한대는 있어야 합니다.");
        }
    }

    private Car moveAndStay(MovePolicy movePolicy, Car car) {
        if (movePolicy.isMove()) {
            return car.move();
        }
        return car;
    }

    private void addWinnerCar(List<Car> winners, Car car, Position maxPosition) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car);
        }
    }

    private Position findMaxPositionValue() {
        Position maxPosition = Position.zero();
        for (Car car : content) {
            final Position currentPosition = car.position();
            maxPosition = compare(maxPosition, currentPosition);
        }
        return maxPosition;
    }

    private Position compare(Position position1, Position position2) {
        if (position1.compareTo(position2)) {
            return position2;
        }
        return position1;
    }
}
