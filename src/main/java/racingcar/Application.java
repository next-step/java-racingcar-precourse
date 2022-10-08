package racingcar;

import racingcar.Machine.RacingCarGameMachine;
import racingcar.domain.service.RacingCarGame;

public class Application {
    public static void main(String[] args) {
        RacingCarGameMachine racingCarGameMachine = new RacingCarGameMachine(new RacingCarGame());
        racingCarGameMachine.start();
    }
}
