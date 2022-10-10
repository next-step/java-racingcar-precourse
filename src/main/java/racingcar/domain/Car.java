package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {
    private final CarName carName;
    private final Move move;
    private final Location location;

    public Car(String name) {
        this.carName = new CarName(name);
        this.location = new Location();
        this.move = new Move();
    }

    public boolean play() {
        move.execute(Randoms.pickNumberInRange(0, 9));
        location.apply(move.isMoved());
        return move.isMoved();
    }

    public Location getLocation() {
        return location;
    }

    public CarName getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return carName.equals(car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
