import controller.RacingGameController;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.carInit();
        racingGameController.runGame();
    }
}
