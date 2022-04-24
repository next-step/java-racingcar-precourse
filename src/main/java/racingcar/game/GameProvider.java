package racingcar.game;

public class GameProvider {

    private final Game game;

    public GameProvider(Game game) {
        this.game = game;
    }

    public static GameProvider from(Game game) {
        return new GameProvider(game);
    }

    public void start() {
        game.play();
    }
}
