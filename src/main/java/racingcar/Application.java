package racingcar;

import racingcar.common.SystemMessage;
import racingcar.domain.Game;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();

        int tryTime = game.getTryTime();
        System.out.println(SystemMessage.RESULT);
        for (int index = 0; index < tryTime; index++) {
            game.turn();
            game.printResult();
        }
        System.out.println(SystemMessage.WINNER + game.getWinner() + " 입니다.");
    }
}
