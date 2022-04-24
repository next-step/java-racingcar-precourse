package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.common.SystemMessage;

public class Game {
    private RacingCars racingCars;
    private int tryTime;

    private final int GO_VALUE = 4;
    private final int MAX_VALUE = 9;
    private final int MIN_VALUE = 0;

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

    public void turn() {
        List<RacingCar> racingCarsList = racingCars.getRacingCars();
        for (int index = 0; index < racingCarsList.size(); index++) {
            goOrStrop(setRandomNumber(), index + 1);
        }
    }

    private int setRandomNumber() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

    private void goOrStrop(int value, int index) {
        if (GO_VALUE <= value) {
            goRacingCar(index);
        }
    }

    private void goRacingCar(int index) {
        RacingCar racingCar = racingCars.getRacingCarByIndex(index);
        racingCar.goRacingCar();
    }

    public int getTryTime() {
        return this.tryTime;
    }


}
