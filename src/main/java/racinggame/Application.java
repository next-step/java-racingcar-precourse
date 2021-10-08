package racinggame;

import racinggame.view.InputView;
import racinggame.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        RacingGame game = InputView.inputCarNames();
        game.setTryCnt(Integer.parseInt(InputView.inputTryCount()));
        OutputView.printRacingGame(game);
    }
}
