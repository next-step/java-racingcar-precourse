package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingRound;
import racingcar.domain.car.CarName;
import racingcar.view.ReadyView;
import racingcar.view.StartView;

import java.util.List;

public class RacingController {

    private final ReadyView readyView;
    private final StartView startView;

    public RacingController(ReadyView readyView, StartView startView) {
        this.readyView = readyView;
        this.startView = startView;
    }

    public RacingGame readyRacing() {
        List<CarName> carNames = readyView.createCarNames();
        RacingCars racingCars = RacingCars.of(carNames);
        RacingRound racingRound = readyView.createRacingRound();
        return new RacingGame(racingCars, racingRound);
    }

    public void startRacing(RacingGame racingGame) {
        startView.showRacingGame(racingGame);
    }

}
