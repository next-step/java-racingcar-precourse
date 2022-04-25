package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Round {

    private Map<CarName, Mileage> record = new HashMap<>();

    public void record(CarName carName, Mileage mileage) {
        record.put(carName, mileage);
    }

    public Mileage getMileage(CarName carName) {
        return record.get(carName);
    }

    public Winners getWinners() {
        Mileage maxMileage = getMaxMileage();

        Winners winners = new Winners();
        for (Map.Entry<CarName, Mileage> entry : record.entrySet()) {
            addWinners(winners, maxMileage, entry);
        }
        return winners;
    }

    private void addWinners(Winners winners, Mileage maxMileage, Map.Entry<CarName, Mileage> entry) {
        if (maxMileage.isSame(entry.getValue())) {
            winners.add(entry.getKey());
        }
    }

    private Mileage getMaxMileage() {
        return Collections.max(record.values());
    }
}
