package racinggame;

import racinggame.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        final RacingGameController controller = new RacingGameController();
        controller.play();
    }
}
