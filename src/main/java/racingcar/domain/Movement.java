package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Movement {
    private static final int POSITIVE_NUMBER = 1;
    private static final int DECREASE_NUMBER = 1;
    private static final int INITIAL_CACHED_MIN_VALUE = 0;
    private static final int INITIAL_CACHED_MAX_VALUE = 10;
    private static final Map<Integer, Movement> CACHED_MOVEMENT;

    static {
        CACHED_MOVEMENT = new LinkedHashMap<>();
        for (int i = INITIAL_CACHED_MIN_VALUE; i < INITIAL_CACHED_MAX_VALUE; i++) {
            CACHED_MOVEMENT.put(i, new Movement(i));
        }
    }

    private final int round;

    public Movement(String round) {
        int numberOfRound = Integer.parseInt(round);
        if (numberOfRound < POSITIVE_NUMBER) {
            throw new IllegalArgumentException("자동차 경주를 진행할 횟수는 " + POSITIVE_NUMBER + " 이상이어야 합니다.");
        }

        this.round = numberOfRound;
    }

    private Movement(int round) {
        this.round = round;
    }

    public boolean continuable() {
        return round >= POSITIVE_NUMBER;
    }

    public Movement move() {
        if (CACHED_MOVEMENT.containsKey(round - DECREASE_NUMBER)) {
            return CACHED_MOVEMENT.get(round - DECREASE_NUMBER);
        }
        return new Movement(round - DECREASE_NUMBER);
    }
}
