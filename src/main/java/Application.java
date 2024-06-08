import controller.RaceInputController;
import java.util.List;
import model.Car;
import model.Race;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        final RaceInputController inputController = new RaceInputController();
        List<String> carNames = inputController.getUserInputForCarNames();
        int rounds = inputController.getUserInputForRaceCount();

        Race race = new Race(carNames, rounds);
        List<Car> result = race.start();

        OutputView.printRaceStatus(result);
        OutputView.printWinners(result);
    }
}