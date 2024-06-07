import controller.RaceController;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RaceController raceController = new RaceController(inputView, outputView);
        raceController.run();
    }
}