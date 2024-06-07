import controller.GameController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(InputView.inputCarName(), InputView.inputGameIteration());
        OutputView.printGame(gameController);
        InputView.closeScanner();

    }
}
