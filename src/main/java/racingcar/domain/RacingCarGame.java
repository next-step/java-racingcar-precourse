package racingcar.domain;

import static racingcar.domain.constant.RacingCarConstant.SEPERATOR;

public class RacingCarGame {
    private static MoveCondition moveCondition = new MoveCondition();
    private static Cars cars;
    private static Round round;

    public RacingCarGame(String carNames, String round) {
        this.cars = new Cars(carNames.split(SEPERATOR));
        this.round = new Round(round);
    }

    public void play() {
        while (round.executable()) {
            round.execute();
            cars.move(moveCondition);
        }
    }

}
