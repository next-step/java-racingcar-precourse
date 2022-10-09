package racingcar;

import racingcar.controller.Controller;
import racingcar.controller.console.ConsoleController;
import racingcar.enumeration.GameMode;
import racingcar.model.Round;
import racingcar.view.console.ConsoleView;

public class Container {
    private Controller controller;

    public Container(GameMode mode) {
        initGameMode(mode);
    }

    public void initGameMode(GameMode mode) {
        if (mode.equals(GameMode.CONSOLE)) {
            initConsoleMode();
        }
    }

    private void initConsoleMode() {
        controller = new ConsoleController(new ConsoleView(), new Round());
    }

    public void start() {
        controller.start();
    }
}
