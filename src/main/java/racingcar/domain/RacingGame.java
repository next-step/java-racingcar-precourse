package racingcar.domain;

public class RacingGame {
    private RacingCars racingCars;
    private RacingRound racingRound;

    public RacingGame(RacingCars racingCars, RacingRound racingRound) {
        this.racingCars = racingCars;
        this.racingRound = racingRound;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public int getRacingRound() {
        return racingRound.getRacingRound();
    }

}
