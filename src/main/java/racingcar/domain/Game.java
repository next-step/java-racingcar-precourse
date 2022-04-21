package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.SystemMessage;

public class Game {
    private RacingCars racingCars;

    public Game() {
        this.initGame();
    }

    public void initGame() {
        inputRacingCarName();
    }

    private void inputRacingCarName() {
        System.out.println(SystemMessage.INPUT_RACING_CAR_NAME);

        String racingCarName;
        try {
            racingCarName = Console.readLine();
            racingCars = new RacingCars(racingCarName.split(","));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.toString());
            initGame();
        }
    }



}
