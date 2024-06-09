import controller.RacingCarGame;
import java.io.IOException;

public class Application {

    private static final RacingCarGame racingCarGame = new RacingCarGame();

    public static void main(String[] args) throws IOException {
        racingCarGame.racingGame();
    }
}