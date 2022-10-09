package racingcar.controller;

import racingcar.model.cars.Cars;
import racingcar.model.laps.Laps;
import racingcar.model.progress.Judge;
import racingcar.model.progress.MinGoScoreInclusive;
import racingcar.model.progress.Participants;
import racingcar.model.progress.Race;
import racingcar.view.ConsoleCarNames;
import racingcar.view.ConsoleLaps;
import racingcar.view.ConsoleReportProgress;
import racingcar.view.ConsoleReportWinner;

public class Game {
    private final MinGoScoreInclusive minGoScoreInclusive;
    private Laps laps;
    private Participants participants;
    private Judge judge;
    private Race race;

    public Game(MinGoScoreInclusive minGoScoreInclusive) {
        this.minGoScoreInclusive = minGoScoreInclusive;
    }

    public void start() {
        this.ready();
        this.getSet();
        this.go();
        this.finale();
    }

    private void ready() {
        this.initParticipants();
        this.initLaps();
        this.initJudge();
    }

    private void getSet() {
        this.race = new Race(laps, participants, judge);
    }

    private void go() {
        this.printProgressTitle();
        do {
            race.go();
            this.reportProgress();
        } while (!race.isFinished());
    }

    private void finale() {
        this.reportWinner();
    }

    private void initParticipants() {
        Cars cars = ConsoleCarNames.createCars();
        this.participants = Participants.of(cars.get());
    }

    private void initLaps() {
        this.laps = ConsoleLaps.createLaps();
    }

    private void initJudge() {
        this.judge = new Judge(minGoScoreInclusive);
    }

    private void printProgressTitle() {
        ConsoleReportProgress.printTitle();
    }

    private void reportProgress() {
        ConsoleReportProgress.printRaceScore(race.report());
    }

    private void reportWinner() {
        ConsoleReportWinner.printWinner(race.reportWinner());
    }
}
