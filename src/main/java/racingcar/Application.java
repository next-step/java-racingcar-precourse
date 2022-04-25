package racingcar;

import java.util.Scanner;
import racingcar.domain.CarManager;
import racingcar.domain.GameInput;
import racingcar.domain.GameOperator;
import racingcar.service.RacingGameExecutePlan;
import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        new RacingGameExecutePlan().gameExecutePlan();
    }
}
