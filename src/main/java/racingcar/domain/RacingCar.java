package racingcar.domain;

import racingcar.constants.ErrorMessage;
import racingcar.utils.RandomNumberCreator;

public class RacingCar {
    private static final Integer NAME_LIMIT = 5;
    private static final Integer GO_FORWARD_STANDARD = 4;
    private String name;
    private Integer distance;

    public RacingCar(final String name) {
        this(name, 0);
    }

    public RacingCar(final String name, final Integer distance) {
        final String trimmedName = name.trim();
        if (trimmedName.length() > NAME_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_IS_MORE_THAN_FIVE);
        }
        if (trimmedName.equals("") || trimmedName.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_EMPTY);
        }
        this.name = trimmedName;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void race() {
        if (canGoForward()) {
            distance += 1;
        }
    }

    private boolean canGoForward() {
        final Integer randomNumber = RandomNumberCreator.makeRandomNumber();
        return randomNumber >= GO_FORWARD_STANDARD;
    }

}
