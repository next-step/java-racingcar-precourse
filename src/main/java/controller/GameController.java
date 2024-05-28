package controller;

import java.util.List;
import model.Game;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

/**
 * 게임을 진행하는 클래스
 */
public class GameController {

    /**
     * 게임을 진행하는 메서드
     */
    public static void playGame() {

        List<String> carNames = InputView.inputCarNames();
        int attemptCount = InputView.inputAttemptCount();

        Game game = new Game(carNames);

        OutputView.printResultString();

        for (int i = 0; i < attemptCount; i++) {
            for (String carName : carNames) {
                determineAdvanceAndReflect(carName, game);
            }

            OutputView.printProcess(game.getCarPosition());
        }

        List<String> winners = game.getWinners();
        OutputView.printWinners(winners);
    }

    /**
     * 전진하는지 판단하는 메서드
     *
     * @param num 랜덤 숫자
     * @return 전진 여부
     */
    private static boolean isAdvance(int num) {
        return num >= 5;
    }

    /**
     * 랜덤 숫자를 바탕으로 전진 여부를 결정하고, 전진하기로 결정된 경우 이를 수행하는 메서드
     *
     * @param carName 자동차 이름
     * @param game    게임
     */
    private static void determineAdvanceAndReflect(String carName, Game game) {
        if (isAdvance(RandomNumberGenerator.getRandomNumber())) {
            game.advance(carName);
        }
    }

}
