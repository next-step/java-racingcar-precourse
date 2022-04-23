package racingcar.model;

import java.util.List;

public class RacingGame {

    private RacingCars racingCars;

    private Round round;


    public void ready(String carName) {
        this.racingCars = RacingCars.from(carName);
    }

    public void initRound(String round) {
        this.round = Round.from(round);
    }

    public void play() {
        racingCars.playByRound(this.getRound());
    }

    public List<RacingCar> getPlayResult() {
        return this.racingCars.getRacingCarList();
    }

    public int getRound() {
        return this.round.getRound();
    }

    public List<String> getWinners() {
        return racingCars.findWinners();
    }
}
