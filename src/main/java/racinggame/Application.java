package racinggame;

import racinggame.domain.Player;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new Player());
        game.start();
    }
}
