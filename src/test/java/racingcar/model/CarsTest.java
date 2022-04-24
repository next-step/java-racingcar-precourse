package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.Console;

public class CarsTest {
    @Test
    void createCarsTest(){
        String carNames = "pobi,woni";
        Cars cars = new Cars(carNames);
        Assertions.assertAll(
                () -> cars.getCars().get(0).getName().equals("pobi"),
                () -> cars.getCars().get(1).getName().equals("woni")
        );
    }

    @Test
    void createCarsTest_Failed(){
        String carNames = "pobi.woni";
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Cars cars = new Cars(carNames);
        });
    }

    @Test
    void carsMoveForwardTest(){
        String carNames = "pobi,woni";
        Cars cars = new Cars(carNames);
        cars.moveForward();
        Assertions.assertAll(
                () -> cars.getCars().get(0).getName().equals("pobi"),
                () -> cars.getCars().get(1).getName().equals("woni")
        );
        Assertions.assertAll(
                () -> Assertions.assertTrue(cars.getCars().get(0).getSteps() >=0 && cars.getCars().get(0).getSteps() <= 9),
                () -> Assertions.assertTrue(cars.getCars().get(0).getSteps() >=0 && cars.getCars().get(0).getSteps() <= 9)
        );
    }

    @Test
    void priorityQueueTest(){
        Car car1 = new Car("car1");
        car1.setSteps(1);
        Car car2 = new Car("car2");
        car2.setSteps(3);
        Car car3 = new Car("car3");
        car3.setSteps(3);

        List<Car> _cars = Arrays.asList(car1, car2, car3);
        Cars cars = new Cars();
        cars.setCars(_cars);
        List<Car> winners = cars.getWinners();
        System.out.println(winners);
        Console.printWinner(cars);
    }
}
