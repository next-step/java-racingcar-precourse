package racingcar;

import camp.nextstep.edu.missionutils.Console;
import game.CarRaceGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarRaceGame carRaceGame = new CarRaceGame();

        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        carRaceGame.setRacingCars();
        System.out.println("시도할 회수");
        carRaceGame.setCarMoveCount();
        carRaceGame.start();
    }
}
