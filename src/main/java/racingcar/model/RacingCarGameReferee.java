package racingcar.model;

import racingcar.common.Constants;

import java.util.Collections;

public class RacingCarGameReferee {
    int winnerRacingCarPosition;

    public RacingCarGameReferee() {
    }

    public void racingCarGameRoundsProcessing(RacingCars racingCars
                                            , int racingCarGameRoundNumber
                                            , GameRoundRandomNumberGanerator gameRoundRandomNumberGanerator) {

        for (int i = 0; i < racingCarGameRoundNumber; i++) {
            eachRoundProcessing(racingCars, gameRoundRandomNumberGanerator);
        }
    }

    private void eachRoundProcessing(RacingCars racingCars, GameRoundRandomNumberGanerator gameRoundRandomNumberGanerator) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            processCarMoving(racingCar, gameRoundRandomNumberGanerator);
        }
    }

    private void processCarMoving(RacingCar racingCar, GameRoundRandomNumberGanerator gameRoundRandomNumberGanerator) {
        if (gameRoundRandomNumberGanerator.generateRacingCarGameRoundNumber() >= Constants.RACING_CAR_GAME_MOVE_STANDARD_NUMBER) {
            racingCar.frontMove();
        }
    }

    public RacingCars calculateRacingCarGameResult(RacingCars racingCars) {
        RacingCars winnerRacingCars = new RacingCars();
        lineUpRacingCarsAndGetWinnerPosition(racingCars);

        for (RacingCar racingCar : racingCars.getRacingCars()) {
            addRacingCarGameWinner(racingCar, winnerRacingCars);
        }

        return winnerRacingCars;
    }

    private void addRacingCarGameWinner(RacingCar racingCar, RacingCars racingCars) {
        if (isRacingCarGameWInner(racingCar)) {
            racingCars.addRacingCar(racingCar);
        }
    }

    private boolean isRacingCarGameWInner(RacingCar racingCar) {
        if (this.winnerRacingCarPosition <= racingCar.getPosition()) {
            return true;
        }

        return false;
    }

    private void lineUpRacingCarsAndGetWinnerPosition(RacingCars racingCars) {
        Collections.sort(racingCars.getRacingCars(), (a, b) -> b.getPosition() - a.getPosition());
        winnerRacingCarPosition = racingCars.getRacingCars().get(0).getPosition();
    }
}
