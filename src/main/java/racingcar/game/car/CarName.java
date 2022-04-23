package racingcar.game.car;

import racingcar.game.GameConfig;
import racingcar.game.util.SingleValue;

public class CarName extends SingleValue<String> {
    public CarName(String name) {
        super(name);
        validateNameLength(name);
    }

    static void validateNameLength(String name) {
        String trimmed = name.trim();
        if (trimmed.length() > GameConfig.MAX_CAR_NAME_LENGTH || trimmed.length() < GameConfig.MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("length of name must be between "
                    + GameConfig.MIN_CAR_NAME_LENGTH + " and " + GameConfig.MAX_CAR_NAME_LENGTH);
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
