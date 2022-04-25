package racingcar.car;

import static racingcar.utils.ObjectUtils.isEmpty;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import racingcar.racing.RacingCarResult;

public class Car {
    public static final int MIN = 0;
    public static final int MAX = 9;
    public static final int GO_NUMBER = 4;
    private CarName carName;

    private Car(final CarName carName) {
        this.carName = carName;
    }

    public static Car of(final CarName carName) {
        validateCarName(carName);
        return new Car(carName);
    }

    public RacingCarResult race() {
        return isGreaterThanGoNumber() ? RacingCarResult.GO : RacingCarResult.STOP;
    }

    public CarName getCarName() {
        return carName;
    }

    private static void validateCarName(final CarName carName) {
        if (isEmpty(carName))  {
            throw new IllegalArgumentException("[ERROR] CarName 은 null 일 수 없습니다.");
        }
    }

    private boolean isGreaterThanGoNumber() {
        return Randoms.pickNumberInRange(MIN, MAX) >= GO_NUMBER;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        final Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
