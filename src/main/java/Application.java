import controller.RaceController;
import controller.RaceInputController;
import java.util.List;
import model.Race;

public class Application {
    public static void main(String[] args) {
        final RaceInputController inputController = new RaceInputController();
        List<String> carNames = inputController.getUserInputForCarNames();
        int rounds = inputController.getUserInputForRaceCount();
        final Race race = new Race(carNames);

        RaceController raceController = new RaceController(race, rounds);
        raceController.startRace();

    }
}