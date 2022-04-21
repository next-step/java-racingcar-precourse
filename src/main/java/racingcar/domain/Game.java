package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.SystemMessage;

public class Game {
    private RacingCars racingCars;
    private int tryTime;

    public Game() {
        this.initGame();
    }

    public void initGame() {
        inputRacingCarName();
        inputTryTime();
    }

    private void inputRacingCarName() {
        System.out.println(SystemMessage.INPUT_RACING_CAR_NAME);

        String racingCarName;
        try {
            racingCarName = Console.readLine();
            System.out.println("자동차 : " + racingCarName);
            racingCars = new RacingCars(racingCarName.split(","));
        } catch (IllegalArgumentException exception) {
            System.out.println(SystemMessage.CAR_NAME_LENGTH_EXCEPTION);
            inputRacingCarName();
        }
    }

    private void inputTryTime() {
        System.out.println(SystemMessage.INPUT_TIMES);

        try {
            tryTime = Integer.parseInt(Console.readLine());
            System.out.println("시도 : " + tryTime);
        } catch (IllegalArgumentException exception) {
            System.out.println(SystemMessage.NUMBER_EXCEPTION);
            inputTryTime();
        }
    }



}
