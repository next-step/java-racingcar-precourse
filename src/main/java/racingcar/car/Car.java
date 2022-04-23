package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Lists;

import java.util.List;

public class Car {
    private static final int MOVE_BOUNDARY = 3;

    private final CarName name;
    private final CarPosition position;

    public Car(CarName name) {
        this.name = name;
        this.position = new CarPosition();
    }

    public CarName getName() {
        return this.name;
    }

    public CarPosition getPosition() {
        return this.position;
    }

    public void randomMove() {
        if (isGo(Randoms.pickNumberInRange(0, 9))) {
            this.position.moveForward();
        }
    }

    public static List<Car> toList(List<CarName> carNames) {
        List<Car> results = Lists.newArrayList();
        for (CarName carName : carNames) {
            results.add(new Car(carName));
        }
        return results;
    }

    private boolean isGo(int value) {
        return value > MOVE_BOUNDARY;
    }
}
