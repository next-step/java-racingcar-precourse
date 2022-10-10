package racingcar.dto;

import racingcar.model.Distance;
import racingcar.model.Name;

public class GameHistory {

    private static final String MINUS_SIGN = "-";
    private final Name name;

    private final Distance distance;

    public GameHistory(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public String getName() {
        return name.getName();
    }

    public String getDistance() {
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < distance.getDistance(); i++) {
            st.append(MINUS_SIGN);
        }

        return st.toString();
    }
}
