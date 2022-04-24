package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingReport {

    private final Map<Car, Distance> report = new HashMap<>();

    public List<Car> winners() {
        Distance longest = longestDistance();
        List<Car> winners = new ArrayList<>();

        for (Car car : report.keySet()) {
            addWinner(winners, longest, car);
        }

        return winners;
    }

    private void addWinner(List<Car> winners, Distance longest, Car target) {
        if (report.get(target).equals(longest)) {
            winners.add(target);
        }
    }

    public Map<Car, Distance> getReport() {
        return report;
    }

    public void write(Car car, Distance distance) {
        report.put(car, distance);
    }

    private Distance longestDistance() {
        Distance longest = new Distance(0);
        for (Distance distance : report.values()) {
            longest = replaceIfLongerThen(longest, distance);
        }

        return longest;
    }

    private Distance replaceIfLongerThen(Distance longest, Distance target) {
        if (target.longerThen(longest)) {
            return target;
        }

        return longest;
    }
}
