import controller.GameController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // InputView.inputCarName();
        // InputView.inputCarName();
        GameController gameController = new GameController();
        OutputView.printResult(gameController);
    }
}
