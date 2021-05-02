package racingcar.domain;

import static racingcar.domain.rule.RacingCarGameRule.SEPERATOR;

public class RacingCarGame {
    private static Cars cars;
    private static Round round;

    public RacingCarGame(String carNames, String round) {
        this.cars = new Cars(carNames.split(SEPERATOR));
        this.round = new Round(round);
    }
}
