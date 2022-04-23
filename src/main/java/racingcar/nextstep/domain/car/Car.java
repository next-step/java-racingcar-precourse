package racingcar.nextstep.domain.car;

import racingcar.nextstep.domain.racing.chart.RacingChart;
import racingcar.nextstep.global.message.Number;
import racingcar.nextstep.global.message.TextMessage;
import racingcar.nextstep.global.utils.Randoms;

public class Car {


    private final CarName carName;
    private CarPosition carPosition;

    public Car(CarName carName) {
        this.carName = carName;
        this.carPosition = CarPosition.zero();
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    public void inputCarPosition(CarPosition carPosition) {
        this.carPosition = carPosition;
    }

    public static Car of(CarName carName) {
        return new Car(carName);
    }

    public void racing() {
        final int randomValue = Randoms.pickNumberInRange(Number.RANDOM_MIN_VALUE, Number.RANDOM_MAX_VALUE);
        if (isAdvanced(randomValue)) {
            move();
        }
    }

    private boolean isAdvanced(int randomValue) {
        return randomValue >= Number.ADVANCE_VALUE;
    }

    private void move() {
        carPosition = CarPosition.addValue(carPosition.getValue());
    }

    public RacingChart createRacingChart() {
        final StringBuilder result = new StringBuilder();
        for (int i = Number.MIN_VALUE; i < carPosition.getValue(); i++) {
            result.append(TextMessage.DASH);
        }
        return RacingChart.of(this, result.toString());
    }
}
