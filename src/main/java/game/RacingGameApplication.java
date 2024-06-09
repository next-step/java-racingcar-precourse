package game;

import game.controller.RacingGameController;
import game.view.InputView;
import game.view.OutputView;
import java.util.Scanner;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        RacingGameController racingGameController = new RacingGameController(inputView, outputView);

        racingGameController.startGame();
    }

}
