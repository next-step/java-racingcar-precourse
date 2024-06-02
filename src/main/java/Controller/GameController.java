package Controller;

import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

import View.RacingView;
import Model.Racing;
import Model.ErrorDetect;

public class GameController {
    private List<String> carNames;
    private String rounds;
    private Racing carRacing;
    private Scanner scanner = new Scanner(System.in);

    public void getCarNames() {
        RacingView.printCarNameMessage();
        carNames = Arrays.asList(scanner.nextLine().split(","));
    }

    public void getRounds() {
        RacingView.printRacingRoundMessage();
        rounds = scanner.nextLine();
        ErrorDetect.roundsTest(rounds);
        System.out.println();
    }

    public void gamePlay() {
        carRacing = new Racing(carNames, rounds);

        RacingView.printRacingRoundResultMessage();
        for (int i=0; i<carRacing.getRounds(); i++) {
            carRacing.playRound();
            RacingView.printOneRoundResult(carRacing.getCarList());
            System.out.println();
        }
    }

    public void gameResult() {
        RacingView.printWinners(carRacing.getWinners());
    }
}
