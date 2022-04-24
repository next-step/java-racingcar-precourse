package racingcar.exception;

import java.lang.Thread.UncaughtExceptionHandler;
import racingcar.view.userinferface.GameUserInterface;

public class RacingCarGameExceptionHandler implements UncaughtExceptionHandler {
    private final GameUserInterface gameUserInterface;

    public RacingCarGameExceptionHandler(GameUserInterface gameUserInterface) {
        this.gameUserInterface = gameUserInterface;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        gameUserInterface.error(e.getMessage());
    }
}
