package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.CarName;
import domain.CarNames;
import domain.Laps;
import domain.RaceResult;
import java.util.LinkedHashMap;
import java.util.Map;
import view.OutputView;

public class RacingContoller {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    public static final int LAP = 0;
    public static final int MOVE_FORWARD_BASE_VALUE = 4;
    private static Map<CarName, String> RECORD;
    private static Map<CarName, Integer> MILEAGE;
    public static int MAX_MILEAGE = 0;

    public RaceResult startRace(CarNames carNames, Laps laps) {
        RECORD = new LinkedHashMap<>();
        MILEAGE = new LinkedHashMap<>();
        for (CarName name : carNames.getCarNames()) {
            RECORD.put(name, "");
            MILEAGE.put(name, 0);
        }

        OutputView.broadcastRace(carNames, laps, LAP);
        return getWinner();
    }

    public static void progressRace(CarNames carNames) {
        for (CarName name : carNames.getCarNames()) {
            moveForward(name);
        }
    }

    private static void moveForward(CarName name) {
        if (Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= MOVE_FORWARD_BASE_VALUE) {
            RECORD.put(name, RECORD.get(name) + "-");
            MILEAGE.put(name, MILEAGE.get(name) + 1);
        }
        recordResult(name);
    }

    private static void recordResult(CarName name) {
        if (MILEAGE.get(name) > MAX_MILEAGE) {
            MAX_MILEAGE = MILEAGE.get(name);
        }
        System.out.println(name.getName() + " : " + RECORD.get(name));
    }

    private String selectWinner(String winners, CarName name) {
        if (MILEAGE.get(name) == MAX_MILEAGE) {
            winners += name.getName() + ", ";
        }
        return winners;
    }

    private RaceResult getWinner() {
        String winners = "";
        for (CarName name : MILEAGE.keySet()) {
            winners = selectWinner(winners, name);
        }
        winners = winners.substring(0, winners.length() - 2);
        return new RaceResult(winners);
    }
}
