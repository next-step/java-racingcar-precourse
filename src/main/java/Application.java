import controller.GameController;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        GameController game = new GameController(new InputView(), new OutputView());
        game.run();
    }
}
