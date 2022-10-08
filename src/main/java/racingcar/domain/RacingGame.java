package racingcar.domain;

import racingcar.utils.CommonUtil;
import java.util.ArrayList;

import static racingcar.constant.Constant.*;

public class RacingGame {
    private final Cars cars;
    private final RacingGameRecord racingGameRecord;

    public RacingGame(String names) {
        this.cars = Cars.createCars(names);
        racingGameRecord = new RacingGameRecord(new ArrayList<>());
    }

    public Cars getCars() {
        return cars;
    }

    public RacingGameRecord getRacingGameRecord() {
        return racingGameRecord;
    }

    public void start(int number) {
        while (number-- > 0) {
            for (Car car : cars.getAnswers()) {
                move(car);
            }
            racingGameRecord.addCars((Cars) cars.clone());
        }
    }

    private void move(Car car) {
        car.move(CommonUtil.getRandomNumber(MIN_NUMBER, MAX_NUMBER));
    }
}
