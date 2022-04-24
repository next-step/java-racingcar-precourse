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
            throw new IllegalArgumentException(GamePrinter.ERROR + GamePrinter.ONLY_POSITIVES);
        }
        this.rounds = round;
    }

    public void playEachRound(RacingCar racingCar) {
        Map<String, Integer> racingCarRecords = racingCar.racingCarRecords;
        racingCarRecords.forEach((car, dashLine) -> {
            int dashCount = moveForward(dashLine);
            if (dashLine != dashCount) {
                racingCarRecords.put(car, dashCount);
            }
            GamePrinter.printCarAndDashes(car, dashCount);
        });
    }

    public int moveForward(Integer racingCarRecords) {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= 4
                ? racingCarRecords + 1
                : racingCarRecords;
    }
}
