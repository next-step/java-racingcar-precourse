package racingcar.model;

import static racingcar.constant.Common.CAN_GO_MIN_NUMBER;
import static racingcar.constant.Common.RACE_LAST_IDX;
import static racingcar.constant.Common.RACE_START_IDX;
import static racingcar.constant.Message.RACE_ROUND_RESULT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private List<Car> carList;

    public RacingGame(List<Car> carList) {
        this.carList = carList;
    }

    public void start(Integer racingCount) {
        System.out.println(RACE_ROUND_RESULT);
        for (int i = 0; i < racingCount; i++) {
            raceRound();
            printRecord();
        }
    }

    public void raceRound() {
        for (Car car : carList) {
            Integer raceNumber = Randoms.pickNumberInRange(RACE_START_IDX, RACE_LAST_IDX);
            racing(car, raceNumber);
        }
    }

    public void racing(Car car, Integer raceNumber) {
        if (raceNumber >= CAN_GO_MIN_NUMBER) {
            car.goRoad();
        }
    }

    private void printRecord() {
        for (Car car : carList) {
            car.printRecord();
        }
        System.out.println();
    }
}
