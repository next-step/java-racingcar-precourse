package race.model;

import java.util.List;
import java.util.Random;

public class Race {
    private final List<Car> carList;

    public Race(List<Car> carList) {
        this.carList = carList;
    }

    public void proceedStep(CustomRandom random) {
        for (Car car : carList) {
            if (random.canMove())
                car.moveForward();
        }
    }

}
