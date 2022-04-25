package racingcar.domain;

import racingcar.domain.car.accelpower.AccelPowerStrategy;
import racingcar.domain.car.accelpower.RandomAccelPowerStrategy;
import racingcar.domain.car.CarNames;
import racingcar.domain.racetrack.FinishLine;
import racingcar.domain.racetrack.Lap;
import racingcar.domain.racetrack.RaceTrack;
import racingcar.util.ValidateUtil;
import racingcar.view.RacingView;

public class RacingGame {

    private RaceTrack raceTrack;

    private CarNames carNames;
    private Lap lap;

    public RacingGame() {
    }

    public void prepareGame() {
        loadCarNames();
        loadLap();

        playGame();

        resultGame();
    }

    private void resultGame() {
        FinishLine finishLine = new FinishLine(raceTrack.getCars());
        finishLine.judgeWinners();

        RacingView.showWinners(finishLine);
    }

    private void playGame() {
        raceTrack = new RaceTrack(carNames, lap);
        race(new RandomAccelPowerStrategy());
    }

    private void loadCarNames() {
        try {
            String carNameText = RacingView.getCarNameText();
            carNames = new CarNames(carNameText);
            ValidateUtil.validateNames(carNames.getCarNames());
        } catch (IllegalArgumentException e) {
            RacingView.showMessage(e.getMessage());
            loadCarNames();
        }
    }

    private void loadLap() {
        try {
            String lapText = RacingView.getLapText();
            lap = new Lap(lapText);
        } catch (IllegalArgumentException e) {
            RacingView.showMessage(e.getMessage());
            loadLap();
        }
    }

    public void race(AccelPowerStrategy accelPowerStrategy) {
        do {
            raceTrack.raceEachLap(accelPowerStrategy);
            RacingView.showRaceStatus(raceTrack);
        } while (raceTrack.keepGoing());
    }

}
