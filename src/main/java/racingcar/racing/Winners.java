package racingcar.racing;

import org.assertj.core.util.Lists;
import racingcar.car.Car;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Winners {
    private static final String JOIN_DELIMITER = ", ";

    private final List<String> winners;

    public Winners(Entry entry) {
        this.winners = decisionWinner(entry);
    }

    private List<String> decisionWinner(Entry entry) {
        TreeMap<Integer, List<String>> resultMap = new TreeMap<>(Comparator.reverseOrder());
        for (Car car : entry.getEntryList()) {
            classifyRacingResult(car, resultMap);
        }
        return resultMap.firstEntry().getValue();
    }

    private void classifyRacingResult(Car car, TreeMap<Integer, List<String>> resultMap) {
        int carPosition = car.getPosition().toNumber();
        String carName = car.getName().toText();

        if (resultMap.containsKey(carPosition)) {
            resultMap.get(carPosition).add(carName);
            return;
        }
        resultMap.put(carPosition, Lists.newArrayList(carName));
    }

    public String toText() {
        return String.join(JOIN_DELIMITER, winners);
    }

    public List<String> getWinners() {
        return winners;
    }
}
