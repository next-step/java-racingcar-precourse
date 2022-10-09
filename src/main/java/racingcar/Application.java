package racingcar;

import racingcar.domain.RacingCar;
import racingcar.utils.MovementUtils;

import static racingcar.utils.RacingCarUtils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar racingCar = new RacingCar(
                createRacingCars(consoleInputRacingDriverNames())
        );
        int round = consoleInputRacingRound();

        racingCar.startRace(round);
        printWinner(racingCar.getWinner());
    }
}
