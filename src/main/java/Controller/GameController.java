package Controller;

import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

import View.RacingView;
import Model.Racing;

public class GameController {
    public void gameStart() {
        Scanner scanner = new Scanner(System.in);

        RacingView.printCarNameMessage();
        List<String> carNames = Arrays.asList(scanner.nextLine().split(","));

        RacingView.printRacingRoundMessage();
        String rounds = scanner.nextLine();
        System.out.println();

        Racing carRacing = new Racing(carNames, rounds);

        RacingView.printRacingRoundResultMessage();
        for (int i=0; i<carRacing.getRounds(); i++) {
            carRacing.playRound();
            RacingView.printOneRoundResult(carRacing.getCarList());
            System.out.println();
        }

        RacingView.printWinners(carRacing.getWinners());
    }
}
