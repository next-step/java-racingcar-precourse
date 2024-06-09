import controller.GameController;
import java.io.IOException;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) throws IOException {
        GameController game = new GameController(new InputView(), new OutputView());
        game.run();
    }

}
