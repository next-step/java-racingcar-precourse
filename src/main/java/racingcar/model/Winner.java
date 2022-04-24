package racingcar.model;

import org.junit.platform.commons.util.StringUtils;
import racingcar.view.GamePrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Winner {

    public List<String> winnerNominates = new ArrayList<>();

    public void add(String winner) {
        validateWinner(winner);
        winnerNominates.add(winner);
    }

    private void validateWinner(String winner) {
        if (StringUtils.isBlank(winner)) {
            throw new IllegalArgumentException();
        }
    }

    public void getWinner(Map<String, Integer> carMap) {
        int maxValue = Collections.max(carMap.values());
        for (Map.Entry<String, Integer> m : carMap.entrySet()) {
            if (m.getValue() == maxValue) {
                winnerNominates.add(m.getKey());
            }
        }
        GamePrinter.printWinner(winnerNominates);
    }
}
