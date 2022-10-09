package racingcar;

import racingcar.enumeration.GameMode;

public class Application {
    public static void main(String[] args) {
        new Container(GameMode.CONSOLE).start();
    }
}
