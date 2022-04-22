package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.CarName;
import domain.CarNames;
import domain.Laps;
import java.util.HashMap;
import java.util.Map;

public class RacingContoller {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    public static final int MOVE_FORWARD_BASE_VALUE = 4;
    public static final String MESSAGE_INFO_RACE_RESULT = "실행 결과";
    private static Map<CarName, String> RECORD;

    public void startRace(CarNames carNames, Laps laps) {
        RECORD = new HashMap<>();
        int lap = 0;

        for (CarName name : carNames.getCarNames()) {
            RECORD.put(name, "");
        }

        System.out.println(MESSAGE_INFO_RACE_RESULT);
        while (lap < laps.getLaps()) {
            progressRace(carNames);
            lap++;
            System.out.println();
        }
    }

    private void progressRace(CarNames carNames) {
        for (CarName name : carNames.getCarNames()) {
            moveForward(name);
        }
    }

    private void moveForward(CarName name) {
        if (Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVE_FORWARD_BASE_VALUE) {
            RECORD.put(name, RECORD.get(name) + "-");
        }
        recordResult(name);
    }

    private void recordResult(CarName name) {
        System.out.println(name.getName() + " : " + RECORD.get(name));
    }
}
