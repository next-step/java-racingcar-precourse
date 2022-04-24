package racingcar.domain;

import racingcar.game.Game;
import racingcar.game.GameProvider;

import static racingcar.ui.Output.ERROR_NOT_ALLOW_EMPTY_CAR_NAMES_MESSAGE;

public class CarName {
    private static final String ERROR_NAME_LENGTH_CANNOT_EXCEED_MORE_THAN_RULES = "이름의 길이가 5자를 넘을 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;

    String name;

    public static CarName of(String name) {
        return new CarName(name);
    }

    public CarName(String name) {
        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) throw new IllegalArgumentException(ERROR_NOT_ALLOW_EMPTY_CAR_NAMES_MESSAGE);
        if (trimmedName.length() > MAX_NAME_LENGTH) throw new IllegalArgumentException(ERROR_NAME_LENGTH_CANNOT_EXCEED_MORE_THAN_RULES);
        this.name = trimmedName;
    }

    public String getName() {
        return name;
    }
}
