package racinggame.controller;

import racinggame.domain.*;

import java.util.List;

import static nextstep.utils.Console.readLine;
import static racinggame.domain.GameMessage.*;

public class GameController {
    public void start() {
        /* 자동차 이름 입력 */
        System.out.println(INPUT_RACING_CAR_NAME_WITH_COMMA.getMessage());
        RacingCars racingCars = new RacingCars(readLine());

        /* 시도할 횟수 입력 */
        System.out.println(INPUT_TRY_COUNT.getMessage());
        TryCount tryCount = new TryCount(readLine());

        /* 실행 결과 출력 */
        System.out.println(OUTPUT_GAME_RESULT.getMessage());
        System.out.println(new GameResult(tryCount, racingCars));
    }
}
