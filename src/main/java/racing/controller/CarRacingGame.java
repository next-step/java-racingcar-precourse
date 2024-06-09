package racing.controller;

import racing.model.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

/**
 * 메인 클래스.
 * 사용자 입력을 받아 게임을 설정하고 실행.
 */
public class CarRacingGame {
    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] carNames = inputView.getCarNames();
        int rounds = inputView.getRounds();

        RacingGame game = new RacingGame(carNames, rounds);
        System.out.println("\n실행 결과");

        for (int i = 0; i < rounds; i++) {
            game.playRound();
            resultView.printRoundResult(game.getCarStatuses());
        }

        resultView.printWinners(game.getWinners());
    }
}
