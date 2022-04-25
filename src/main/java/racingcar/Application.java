package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView(Console::readLine);
        final OutputView outputView = new OutputView(System.out::println);
        final RacingGame racingGame = new RacingGame(inputView, outputView);
        racingGame.run();
    }
}
