package racingcar;

import racingcar.domain.CarHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.startGame();
    }

    public void startGame() {
        CarHandler.round();
    }
}
