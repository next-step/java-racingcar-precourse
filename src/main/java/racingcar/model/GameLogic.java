package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.GamePrinter;

import java.util.Map;


// TODO : class 명을 무엇으로 변경하면 좋을지
@Deprecated
public class GameLogic {

    int MIN_NUMBER = 0;
    int MAX_NUMBER = 9;

    /**
     * 해당 라운드의 RacingCar 를 전진시킨다.
     *
     * @param racingCarRecords
     */
    public void playEachRound(Map<String, Integer> racingCarRecords) {
        racingCarRecords.forEach((car, dashLine) -> {
            int dashCount = moveForward(racingCarRecords, car);
            if (dashLine != dashCount) {
                racingCarRecords.put(car, dashCount);
            }
            GamePrinter.printCarAndDashes(car, dashCount);
        });
    }

    private int moveForward(Map<String, Integer> racingCarRecords, String car) {
        int originCount = racingCarRecords.get(car);
        if (isMove()) {
            return originCount + 1;
        }
        return originCount;
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= 4;
    }
}
