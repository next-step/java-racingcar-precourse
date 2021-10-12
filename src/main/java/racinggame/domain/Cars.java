package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String DELIMITER = ",";

    private List<Car> cars;

    public Cars(String names) {
        List<Car> cars = new ArrayList<>();

        List<String> carNames = Arrays.asList(names.split(DELIMITER));

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }


    private void move() {
        for (int index = 0; index < cars.size(); index++) {
            getCar(index).move(getRandomNumber());
        }
    }

    public void gameStart(int attemptCount) {
        for (int count = 0; count < attemptCount; count++) {
            move();
            ResultView.lineBreak();
        }
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int size() {
        return cars.size();
    }
}
