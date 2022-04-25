package racingcar;

import racingcar.logic.RacingCarGameLogic;
import racingcar.ui.GameUI;
import racingcar.ui.RacingCarGameUI;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameUI gameUI = new RacingCarGameUI(new RacingCarGameLogic());
        gameUI.start();
    }
}
