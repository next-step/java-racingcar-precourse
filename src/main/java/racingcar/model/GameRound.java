package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.GamePrinter;

import java.util.Map;

public class GameRound {
    int MIN_NUMBER = 0;
    int MAX_NUMBER = 9;
    public int rounds;

    public GameRound(int round) {
        if (round < 0) {
            throw new IllegalArgumentException();
        }
        this.rounds = round;
    }

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
