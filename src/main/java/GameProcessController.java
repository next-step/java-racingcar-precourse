import java.util.List;

public class GameProcessController {

    public static void gameStart() {
        inputNamePhasePhase();
    }

    private static void inputNamePhasePhase() {
        List<Car> cars = UserInterface.inputCars();
        Track track = new Track();
        track.addCars(cars);
    }
}
