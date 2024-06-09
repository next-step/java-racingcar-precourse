package racingcar;

import racingcar.adapter.ConsoleController;
import racingcar.application.RacingCarService;
import racingcar.application.port.in.RacingCarPlayUseCase;
import racingcar.domain.ForwardRules;
import racingcar.domain.PickNumberRules;
import racingcar.domain.WinnerRules;

public class RacingCarMain {
    public static void main(String[] args) {
        RacingCarPlayUseCase racingCarPlayUseCase = new RacingCarService(
                PickNumberRules.RANDOM,
                ForwardRules.MORE_THAN_FOUR,
                WinnerRules.HIGHEST_POSITION
        );

        ConsoleController consoleController = new ConsoleController(racingCarPlayUseCase);

        consoleController.play();
    }
}
