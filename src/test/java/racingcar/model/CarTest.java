package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;
import racingcar.utils.RandomGenerator;

public class CarTest {
    final String testCarName = "first";

    @Test
    void createCarTest() {
        CarName carName = new CarName(testCarName);
        Car car = new Car(carName);

        Assertions.assertEquals(testCarName, carName.getCarName());
        Assertions.assertEquals(Constants.DEFAULT_CAR_POSITION, car.getCarPosition());
    }

    @Test
    void movingCarTest() {
        CarName carName = new CarName(testCarName);
        Car car = new Car(carName);

        RandomGenerator randomGenerator = new RandomGenerator(3);
        car.moveCarPosition(randomGenerator.getGeneratedNumber());
        Assertions.assertEquals(Constants.DEFAULT_CAR_POSITION, car.getCarPosition());

        RandomGenerator fixedMovingNumber = new RandomGenerator(4);
        car.moveCarPosition(fixedMovingNumber.getGeneratedNumber());
        Assertions.assertEquals(Constants.CAR_MOVING_AMOUNT, car.getCarPosition());
    }

    @Test
    void compareCarTest() {
        CarName carName = new CarName(testCarName);
        Car car = new Car(carName);

        Assertions.assertEquals(car, car.comparePosition(new CarPosition(0)));
    }
}
