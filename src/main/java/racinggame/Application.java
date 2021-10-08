package racinggame;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        RacingGame racingGame = new RacingGame();
        List<Car> carList = racingGame.carSetup();
        Integer tryCount = racingGame.tryCountSetup();
        racingGame.run(carList, tryCount);
    }
}
