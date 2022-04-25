package racingcar;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Cars {

    List<Car> cars;

    public Cars() {

    }

    public Cars(CarNames carNames) {
        this.cars = new ArrayList<>();

        for (String name : carNames.carNameSplit()) {
            CarName carName = new CarName(name);
            this.cars.add(new Car(carName));
        }
    }

    public String whoIsWinner() {

        int max = maxPotition();

        StringBuilder stringBuilder = new StringBuilder();
        for (Car c : cars) {
            stringBuilder.append(c.findWinner(max));
        }

        return stringBuilder.toString().trim().replaceFirst(".$", "");
    }

    private int maxPotition() {
        int max = 0;
        for (Car c : cars) {
            max = max(max, c.nowPosition());
        }
        return max;
    }


}
