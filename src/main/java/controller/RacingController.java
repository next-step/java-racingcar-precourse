package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.CarName;
import domain.CarNames;
import domain.Laps;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RacingController {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    public static final int MOVE_FORWARD_BASE_VALUE = 4;
    public static final String MESSAGE_INFO_RACE_RESULT = "실행 결과";
    private static Map<CarName, String> RECORD;
    private static Map<CarName, Integer> MILEAGE;
    public static int MAX_MILEAGE = 0;

    public void startRace(CarNames carNames, Laps laps) {
        RECORD = new HashMap<>();
        MILEAGE = new LinkedHashMap<>();
        int lap = 0;
        MAX_MILEAGE = 0;

        for (CarName name : carNames.getCarNames()) {
            RECORD.put(name, "");
            MILEAGE.put(name, 0);
        }

        System.out.println(MESSAGE_INFO_RACE_RESULT);
        while (lap < laps.getLaps()) {
            progressRace(carNames);
            lap++;
            System.out.println();
        }

        announceWinner();
    }

    private void progressRace(CarNames carNames) {
        for (CarName name : carNames.getCarNames()) {
            moveForward(name);
        }
    }

    private void moveForward(CarName name) {
        if (Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVE_FORWARD_BASE_VALUE) {
            RECORD.put(name, RECORD.get(name) + "-");
            MILEAGE.put(name, MILEAGE.get(name) + 1);
        }
        recordResult(name);
    }

    private void recordResult(CarName name) {
        if(MILEAGE.get(name) > MAX_MILEAGE) {
            MAX_MILEAGE = MILEAGE.get(name);
        }
        System.out.println(name.getName() + " : " + RECORD.get(name));
    }

    private String selectWinner(String winners, CarName name) {
        if(MILEAGE.get(name) == MAX_MILEAGE) {
            winners += name.getName() + ", ";
        }
        return winners;
    }

    private void announceWinner() {
        System.out.print("최종 우승자: ");
        String winners = "";
        for(CarName name : MILEAGE.keySet()) {
            winners = selectWinner(winners, name);
        }
        winners = winners.substring(0, winners.length() - 2);
        System.out.println(winners);
    }
}
