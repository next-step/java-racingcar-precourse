package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.type.NumberRangeType.END_INCLUSIVE;
import static racingcar.type.NumberRangeType.START_INCLUSIVE;
import static racingcar.view.OutputView.printRacingCar;

public class RacingGame {
    private final TryCount tryCount;
    private final Cars cars;

    public RacingGame(TryCount tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void racingStart() {
        for (int i = 0; i < this.tryCount.getCount(); i++) {
            movingCars();
            printRacingCar(cars);
        }
    }

    public void movingCars() {
        for (Car car : this.cars.getCars()) {
            Racing racing = new Racing(pickNumberInRange(
                    START_INCLUSIVE.getNumber(),
                    END_INCLUSIVE.getNumber()
            ));
            isMovingForward(car, racing);
        }
    }

    public void isMovingForward(Car car, Racing racing) {
        if (racing.isMovingForward()) {
            car.movingForward();
        }
    }
}
