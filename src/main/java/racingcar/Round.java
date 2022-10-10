package racingcar;

import java.util.Map;
import java.util.Set;

public class Round {
    private final Map<String, Integer> round;

    public Round(Map<String, Integer> round) {
        this.round = round;
    }

    public Set<String> getRacerNames() {
        return round.keySet();
    }

    public int getDistance(String racer) {
        return round.get(racer);
    }
}
