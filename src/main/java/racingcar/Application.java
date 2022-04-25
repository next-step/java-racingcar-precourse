package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.ViewController;
import racingcar.exception.MessageException;
import racingcar.model.GameCount;
import racingcar.model.RacingCars;
import racingcar.view.ConsoleOutputView;
import racingcar.view.NextStepInputView;

public class Application {

    private static final ViewController viewController = new ViewController(new NextStepInputView(), new ConsoleOutputView());
    private static final GameController gameController = new GameController();

    public static void main(String[] args) {

        while(validateInput(() -> gameController.initRacingCars(viewController.getCarNames())));
        while(validateInput(() -> gameController.initGameCount(viewController.getGameCount())));
        gameController.play();
        viewController.printMessageWithNewLine("실행 결과");
        viewController.printMessage(gameController.getGameResult());
        viewController.printMessageWithNewLine("최종 우승자: " + gameController.getWinners());
    }

    private static boolean validateInput(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            if(e instanceof MessageException) {
                viewController.printMessageWithNewLine(((MessageException) e).getFormattedErrorMessage());
                return true;
            }
        }

        return false;
    }
}
