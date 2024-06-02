package race;

import java.util.ArrayList;
import view.Input;
import validator.CarNameValidator;

public class Race {
    private ArrayList<Car> cars;
    private int number;

    public Race(ArrayList<String> carNames, int number) {
        this.number = number;
        this.cars = new ArrayList<>(carNames.size());
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void run() {

    }
}
