package racinggame;

import racinggame.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        // System.out.println("a,".substring(0, 1));
        // TODO 자동차 경주 게임 구현
        RacingGame racingGame = new RacingGame();
        racingGame.gameSetting();
        racingGame.startRacing();
        racingGame.awardRacing();
    }
}
