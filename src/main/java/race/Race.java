package race;

import java.util.ArrayList;
import java.util.List;
import view.Input;
import validator.CarNameValidator;

public class Race {
    private ArrayList<Car> cars;
    private int number;
    private ArrayList<String> winners;

    public Race(List<String> carNames, int number) {
        this.number = number;
        winners = new ArrayList<>();
        cars = new ArrayList<>(carNames.size());
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    /**
     * 자동차 경주 게임을 진행한다.
     */
    public void run() {
        for (int i = 0; i < number; i++) {
            for (Car c : cars) {
                c.tryMove();
            }
        }
    }
}
