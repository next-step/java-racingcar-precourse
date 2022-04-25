package racingcar.racing;

import racingcar.car.Car;

public class CumulativeRound {
    private Round round;
    private RoundResults roundResults;

    public CumulativeRound(final Round round, final RoundResults roundResults) {
        this.round = round;
        this.roundResults = roundResults;
    }

    public Round getRound() {
        return round;
    }

    public int summaryGoCountByCar(final Car car) {
        return roundResults.summaryGoCount(car);
    }
}
