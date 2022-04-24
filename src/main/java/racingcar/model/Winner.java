package racingcar.model;

import racingcar.view.GamePrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Winner {

    public List<String> winnerNominates = new ArrayList<>();

    public void getWinner(RacingCar racingCar) {
        Map<String, Integer> carMap = racingCar.racingCarRecords;
        int maxValue = Collections.max(carMap.values());
        for (Map.Entry<String, Integer> m : carMap.entrySet()) {
            if (m.getValue() == maxValue) {
                winnerNominates.add(m.getKey());
            }
        }
        GamePrinter.printWinner(winnerNominates);
    }
}
