package racinggame;

import racinggame.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현

        String cars = "pobi,crong,honux";
        int count = 1;

        RacingGame racingGame = new RacingGame(cars,count);

        racingGame.play();
    }
}
