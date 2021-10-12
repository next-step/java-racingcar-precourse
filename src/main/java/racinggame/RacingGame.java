package racinggame;

import racinggame.domain.*;

public class RacingGame {
    private RacingGameView gameView;
    private RacingCars racingCars;
    private Round round;

    public RacingGame() {
        this.gameView = new RacingGameView();
    }

    public void init() {
        initRacingCars();
        initRound();
    }

    private void initRacingCars() {
        String racingCarsName = gameView.viewCarName();
        this.racingCars = new RacingCars(racingCarsName);
    }

    private void initRound() {
        int round = gameView.viewRoundCount();
        this.round = new Round(round);
    }

    public void start() {
        while (round.next()) {
            RaceRecords raceRecords = racingCars.playRound();
            raceRecords.report();
        }
        end();
    }

    private void end() {
        RaceResults raceResults = racingCars.results();
        Winners winners = raceResults.judgeWinners();
        winners.report();
    }
}
