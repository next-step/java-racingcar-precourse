package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.GameMessage;
import racingcar.controller.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        try {
            System.out.println(GameMessage.CAR_NAME_REQUEST_MESSAGE);
            String carNames = Console.readLine();
            racingCarGame.setCarGroups(carNames);
            System.out.println(GameMessage.CAR_TRY_COUNT_REQUEST_MESSAGE);
            String tryCount = Console.readLine();
            racingCarGame.setTryCount(tryCount);
            racingCarGame.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
