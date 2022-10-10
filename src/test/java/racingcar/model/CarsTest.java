package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomGenerator;

public class CarsTest {
    final String firstCarNameString = "one";
    final String secondCarNameString = "two";

    @Test
    void createCars() throws IllegalAccessException {
        Cars cars = new Cars();
        CarName firstCarName = new CarName(firstCarNameString);
        Car firstCar = new Car(firstCarName);
        CarName secondCarName = new CarName(secondCarNameString);
        Car secondCar = new Car(secondCarName);

        cars.addCar(firstCar);
        Assertions.assertEquals(firstCar, cars.getAt(0));
        Assertions.assertThrows(IllegalAccessException.class, () -> cars.getAt(1));
        cars.addCar(secondCar);
        Assertions.assertEquals(secondCar, cars.getAt(1));
        Assertions.assertEquals(2, cars.getCars().size());
    }

    @Test
    void getWinnerTest() {
        Cars cars = new Cars();
        CarName firstCarName = new CarName(firstCarNameString);
        Car firstCar = new Car(firstCarName);
        CarName secondCarName = new CarName(secondCarNameString);
        Car secondCar = new Car(secondCarName);

        while(secondCar.getCarPosition() != 1) {
            RandomGenerator randomGenerator = new RandomGenerator();
            secondCar.moveCarPosition(randomGenerator.getGeneratedNumber());
        }

        cars.addCar(firstCar);
        cars.addCar(secondCar);
        Cars winningCars = cars.getWinners();
        Assertions.assertEquals(secondCar.getCarName(), winningCars.toString());
    }

    @Test
    void getDoubleWinnerTest() {
        Cars cars = new Cars();
        CarName firstCarName = new CarName(firstCarNameString);
        Car firstCar = new Car(firstCarName);
        while(firstCar.getCarPosition() != 1) {
            RandomGenerator randomGenerator = new RandomGenerator();
            firstCar.moveCarPosition(randomGenerator.getGeneratedNumber());
        }

        CarName secondCarName = new CarName(secondCarNameString);
        Car secondCar = new Car(secondCarName);
        while(secondCar.getCarPosition() != 1) {
            RandomGenerator randomGenerator = new RandomGenerator();
            secondCar.moveCarPosition(randomGenerator.getGeneratedNumber());
        }

        cars.addCar(firstCar);
        cars.addCar(secondCar);
        Cars winningCars = cars.getWinners();
        Assertions.assertEquals(cars.toString(), winningCars.toString());
    }

    @Test
    void toStringTest() {
        Cars cars = new Cars();
        CarName firstCarName = new CarName(firstCarNameString);
        Car firstCar = new Car(firstCarName);
        CarName secondCarName = new CarName(secondCarNameString);
        Car secondCar = new Car(secondCarName);

        cars.addCar(firstCar);
        cars.addCar(secondCar);
        Cars winningCars = cars.getWinners();
        Assertions.assertEquals(firstCarNameString+", "+secondCarNameString, cars.toString());
    }
}
