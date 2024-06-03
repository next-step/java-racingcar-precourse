import controller.GameController;
import view.InputView;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        InputView.printCarInputQuestion();
        System.out.println(Arrays.toString(InputView.inputCarName()));
        InputView.printIterationInputQuestion();
        System.out.println(InputView.inputGameIteration());
        InputView.closeScanner();
        GameController gameController = new GameController();

    }
}
