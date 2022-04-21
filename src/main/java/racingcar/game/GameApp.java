package racingcar.game;

public class GameApp {
    public static void run() {
        GameExceptionHandler.wrap(Game::play).run();
    }
}
