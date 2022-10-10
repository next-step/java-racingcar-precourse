package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class RaceOfficial {
    Rounds rounds;

    public RaceWinners decideRaceWinnders(RacingCarCenter racingCarCenter) {
        RaceWinners raceWinners = new RaceWinners();
        lineUpRacingCars(racingCarCenter.getRacingCars(), raceWinners);
        for (RacingCar racingCar : racingCarCenter.getRacingCars()) {
            addIfRaceWinner(racingCar, raceWinners, raceWinners.getRaceWinnderPosition());
        }

        return raceWinners;
    }

    public void setRounds(String roundNumber, GameErrors gameErrors) {
        try {
            this.rounds = new Rounds(roundNumber);
        } catch (Exception e) {
            gameErrors.setDefaultMessage(e.getMessage());
            return;
        }
    }

    public Rounds getRounds() {
        return this.rounds;
    }

    public void raceStart(RacingCarCenter racingCarCenter) {
        for (int i = 0; i < rounds.getNumber(); i++) {
            roundStart(racingCarCenter);
        }
    }

    private void lineUpRacingCars(List<RacingCar> racingCars, RaceWinners raceWinners) {
        Collections.sort(racingCars, (a, b) -> b.getPosition() - a.getPosition());
        raceWinners.setRaceWinnderPosition(racingCars.get(0).getPosition());
    }

    private void addIfRaceWinner(RacingCar racingCar, RaceWinners raceWinners, int winnerPosition) {
        if ( isRaceWinner(racingCar, winnerPosition) ) {
            raceWinners.addRaceWinner(racingCar);
        }
    }

    private boolean isRaceWinner(RacingCar racingCar, int winnerPosition) {
        return racingCar.getPosition() >= winnerPosition;
    }

    public void roundStart(RacingCarCenter racingCarCenter) {
        for (RacingCar racingCar : racingCarCenter.getRacingCars()) {
            decideCarMoving(racingCar);
        }
    }

    private void decideCarMoving(RacingCar racingCar) {
        if (isCarMoveForward()) {
            racingCar.moveForward();
        }
    }

    private boolean isCarMoveForward() {
        return RandomNumberGenerator.generate() > 3 ? true : false;
    }
}
