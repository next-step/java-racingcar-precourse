package controller;

import java.util.List;
import model.Game;
import utils.RandomNumberGenerator;
import view.InputView;

public class GameController {

    public static void playGame() {

        List<String> carNames = InputView.inputCarNames();
        int attemptCount = InputView.inputAttemptCount();

        Game game = new Game(carNames);

        for (int i = 0; i < attemptCount; i++) {
            for (String carName : carNames) {
                determineAdvanceAndReflect(carName, game);
            }

            // TODO : 게임 진행 과정을 출력하는 부분 구현 필요
        }
    }

    private static boolean isAdvance(int num) {
        return num >= 5;
    }

    private static void determineAdvanceAndReflect(String carName, Game game) {
        if (isAdvance(RandomNumberGenerator.getRandomNumber())) {
            game.advance(carName);
        }
    }

}
