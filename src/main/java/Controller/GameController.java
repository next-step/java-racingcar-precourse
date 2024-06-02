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
        int state = 0;

        while (state == 0) {
            try {
                RacingView.printCarNameMessage();
                carNames = Arrays.asList(scanner.nextLine().split(","));
                carNames.stream().forEach(carName -> ErrorDetect.carNameTest(carName));
                state = 1;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
}

    public void getRounds() {
        int state = 0;

        while (state == 0) {
            try {
                RacingView.printRacingRoundMessage();
                rounds = scanner.nextLine();
                rounds.chars().forEach(temp -> ErrorDetect.roundsIsValid((char)temp));
                System.out.println(rounds);
                ErrorDetect.roundIsInt(rounds);
                state = 1;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
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
