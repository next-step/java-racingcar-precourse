package racingcar.game.car;

import racingcar.game.util.SingleValue;

public class CarName extends SingleValue<String> {
    public CarName(String name) {
        super(name);
        validateNameLength(name);
    }

    static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] name is too long");
        }
    }

    public String get() {
        return super.get();
    }

    @Override
    public String toString() {
        return super.get();
    }
}
