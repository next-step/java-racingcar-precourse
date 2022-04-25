package racingcar.racing;

import static racingcar.utils.ObjectUtils.isEmpty;

import racingcar.car.Car;

public class Winner {
    private Car car;

    public Winner(final Car car) {
        validateCar(car);
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    private void validateCar(final Car car) {
        if (isEmpty(car)) {
            throw new IllegalArgumentException("[ERROR] 우승자의 자동차는 null 일 수 없습니다.");
        }
    }
}
