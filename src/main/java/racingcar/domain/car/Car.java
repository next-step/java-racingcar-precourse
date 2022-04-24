package racingcar.domain.car;

import org.apache.commons.lang3.RandomUtils;
import racingcar.Constant;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getRandomValue() {
        return RandomUtils.nextInt(Constant.MIN_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
    }

    public void forward(int value) {
        if (value >= Constant.FORWARD_CONDITION) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isWinner(int position) {
        return this.position == position;
    }

    public boolean isLead(int leadPosition) {
        return this.position > leadPosition;
    }
}
