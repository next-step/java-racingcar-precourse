package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.generator.RandomConditionGenerator;
import racingcar.view.RacingGameConsole;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameConsole console = new RacingGameConsole();
        RandomConditionGenerator generator = new RandomConditionGenerator();
        RacingGameController controller = new RacingGameController(console, generator);
        controller.playGame();
    }
}
