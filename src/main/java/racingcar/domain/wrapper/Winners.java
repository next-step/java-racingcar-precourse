package racingcar.domain.wrapper;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private static final String EMPTY = "";
    private static final String DELIMITER = ", ";

    private final List<String> winners;

    public Winners() {
        winners = new ArrayList<>();
    }

    public void add(final String name) {
        if (!isNull(name)) {
            winners.add(name);
        }
    }

    public String getWinners() {
        return String.join(DELIMITER, winners);
    }

    private boolean isNull(final String name) {
        return name == null || EMPTY.equals(name);
    }
}
