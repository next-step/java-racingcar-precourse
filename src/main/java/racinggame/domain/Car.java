package racinggame.domain;

import com.sun.xml.internal.ws.util.StringUtils;
import nextstep.utils.Randoms;
import racinggame.message.Number;

public class Car {

    private CarName carName;
    private CarPosition carPosition;

    public Car(CarName carName) {
        this.carName = carName;
        this.carPosition = new CarPosition();
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    public void move() {
        this.carPosition = CarPosition.addValue(carPosition.getValue());
    }

    public static Car of(CarName carName) {
        return new Car(carName);
    }

    public void racing() {
        final int randomValue = Randoms.pickNumberInRange(Number.RANDOM_MIN_VALUE.getValue(), Number.RANDOM_MAX_VALUE.getValue());
        if (randomValue >= Number.ADVANCE_VALUE.getValue()) {
            move();
        }
    }

    public void printResult() {
        final String result = makeRacingChart(carPosition.getValue());
        System.out.println(carName.getName() + ":" + result);
    }

    private String makeRacingChart(int value) {
        StringBuilder result = new StringBuilder();
        for (int i = Number.MIN_VALUE.getValue(); i < value; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
