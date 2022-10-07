package racingcar;

import racingcar.game.Game;
import racingcar.message.Message;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Game.start();

        } catch (IllegalArgumentException e) {
            System.out.println(Message.INPUT_ERROR.getMessage());
        }
    }
}
