package dev.heowc.car;

import dev.heowc.utils.StringUtils;
import dev.heowc.condition.Condition;

public final class RacingCar {

    public static final int INIT_COUNT = 0;
    public static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private final Condition condition;
    private int position;

    public static RacingCar from(String name, Condition condition) {
        return new RacingCar(name, condition);
    }

    private RacingCar(String name, Condition condition) {
        this(name, condition, INIT_COUNT);
    }

    private RacingCar(String name, Condition condition, int count) {
        validate(name);
        this.name = name;
        this.condition = condition;
        this.position = count;
    }

    private static void validate(String value) {
        if (!StringUtils.hasText(value)) {
            throw new NullPointerException("name is empty");
        }
        if (value.length() > NAME_LENGTH_LIMIT) {
            throw new LengthLimitExceededException(value);
        }
    }



    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove(Condition condition) {
        if (this.condition.compareTo(condition) <= 0) {
            move();
        }
    }

    private void move() {
        position++;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", getName(), StringUtils.repeat('-', getPosition()));
    }
}
