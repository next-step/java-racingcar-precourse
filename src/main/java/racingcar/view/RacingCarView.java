package racingcar.view;

import static racingcar.domain.RacingCarRule.GAME_FINISH;
import static racingcar.domain.RacingCarRule.INPUT_NUMBER_TO_TRY;
import static racingcar.domain.RacingCarRule.RACING_CAR_NAME_INPUT;

public class RacingCarView {

    public void init() {
        this.println(RACING_CAR_NAME_INPUT);
    }

    public void inputNumber() {
        this.println(INPUT_NUMBER_TO_TRY);
    }

    public void finish(String message) {
        this.println(GAME_FINISH + message);
    }

    public void println(String message) {
        System.out.println(message);
    }
}
