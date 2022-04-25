package racingcar;

import racingcar.domain.RacingCar;
import racingcar.ui.ConsoleInterface;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar racingCarGame = new RacingCar(ConsoleInterface.getInstance());
        racingCarGame.start();
    }
}
