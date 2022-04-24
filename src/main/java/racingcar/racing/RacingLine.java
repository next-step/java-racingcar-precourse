package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;

public class RacingLine {

    public static final int MIN_RANDOM = 0;
    public static final int MAX_RANDOM = 9;
    public static final int MIN_GO_STRAIGHT = 4;

    private final Car racingCar;
    private int position;

    public RacingLine(Car car) {
        assertRacingCar(car);

        this.racingCar = car;
        position = 0;
    }

    public Car getRacingCar() {
        return racingCar;
    }

    public int getPosition() {
        return position;
    }

    public String getRacingCarName() {
        return this.racingCar.getName();
    }

    int getRandom() {
        return Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
    }

    public void goStraight() {
        if (getRandom() >= MIN_GO_STRAIGHT) {
            position++;
        }
    }

    private void assertRacingCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("자동차는 null 일 수 없습니다");
        }
    }
}
