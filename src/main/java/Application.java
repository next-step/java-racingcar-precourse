import controller.RaceInputController;
import java.util.List;
import model.Car;

public class Application {
    public static void main(String[] args) {
        RaceInputController inputController = new RaceInputController();

        final int amount = inputController.getUserInputForRaceCount();
        final List<Car> cars = lottoService.purchaseLottos(amount);
    }
}