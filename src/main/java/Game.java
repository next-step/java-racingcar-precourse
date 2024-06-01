import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> racingCars = new ArrayList<>();

    private void createCars(String carNameInput) {
        for (String carName : carNameInput.split(",")) {
            racingCars.add(new Car(carName));
        }
    }
}
