package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
    private static final int CRITERIA_NUMBER = 0;
    private static final int INCREASE_NUMBER = 1;
    private static final int INITIAL_CACHED_MIN_VALUE = 0;
    private static final int INITIAL_CACHED_MAX_VALUE = 10;
    private static final Map<Integer, Position> CACHED_POSITIONS = new LinkedHashMap<Integer, Position>() {{
        for (int i = INITIAL_CACHED_MIN_VALUE; i < INITIAL_CACHED_MAX_VALUE; i++) {
            put(i, new Position(i));
        }
    }};

    private final int position;

    public Position(int position) {
        if (position < CRITERIA_NUMBER) {
            throw new IllegalArgumentException("자동차의 위치는 음수가 될 수 없습니다.");
        }

        this.position = position;
    }

    public Position move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return cachedPosition();
        }
        return this;
    }

    Position cachedPosition() {
        if (CACHED_POSITIONS.containsKey(position + INCREASE_NUMBER)) {
            return CACHED_POSITIONS.get(position + INCREASE_NUMBER);
        }
        return new Position(position + INCREASE_NUMBER);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position >= maxPosition;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
