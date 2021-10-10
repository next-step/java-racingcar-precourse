package racinggame.controller;

import racinggame.domain.RaceCar;
import racinggame.domain.RaceFinishResult;
import racinggame.domain.RaceRound;
import racinggame.exception.RaceGameException;
import racinggame.service.RaceGameService;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.List;
import java.util.NoSuchElementException;

public class GameMachine {

    final private InputView inputView;
    final private OutputView outputView;
    final private RaceGameService raceGameService;

    public GameMachine() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.raceGameService = new RaceGameService();
    }

    public void runRaceGame() {
        try {
            List<String> userInputCarsName = inputView.getUserInputCarsName();
            int userInputTryCount = inputView.getUserInputTryCount();
            RaceFinishResult raceFinishResult = raceGameService.startRace(userInputCarsName, userInputTryCount);
            printRaceGameResult(raceFinishResult);
        } catch (RaceGameException rge) {
            outputView.printErrorMessage(rge.getMessage());
            throw new NoSuchElementException();
        }
    }

    private void printRaceGameResult(RaceFinishResult raceFinishResult) {
        printRaceRounds(raceFinishResult.getRaceRounds());
        printFinalWinners(raceFinishResult.getRaceWinners());
    }

    private void printFinalWinners(String raceWinners) {
        outputView.printRaceWinner(raceWinners);
    }

    private void printRaceRounds(List<RaceRound> raceRounds) {
        System.out.println("\n실행결과");
        raceRounds.forEach(round -> printRaceRound(round.getRaceCars()));
    }

    private void printRaceRound(List<RaceCar> raceCars) {
        raceCars.forEach(raceCar -> outputView.printRaceRound(raceCar));
        System.out.println("\n");
    }

}
