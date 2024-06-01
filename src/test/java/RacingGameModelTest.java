import domain.Car;
import model.RacingGameModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameModelTest {
    private RacingGameModel racingGameModel;
    Car[] cars;
    @BeforeEach
    void 사전준비() {
        String[] carNames = {"Car1", "Car2", "Car3"};
        racingGameModel = new RacingGameModel(carNames);


    }

    @DisplayName("경주를 하고 난 결과가 Car인스턴스들에 잘 반영이 되는지 테스트")
    @Test
    void testUpdateCars() {
        for (Car car : racingGameModel.getCars()) {
            int randomNumber = racingGameModel.generateRandomNumber();
            //4이상이면 전진
            if (randomNumber >= 4) {
                car.forward();
                assertEquals(1, car.getRaceDistance());
            } else {
                assertEquals(0, car.getRaceDistance());
            }
        }
    }
    @DisplayName("0~9랜덤 숫자가 잘 생성되는지 테스트")
    @Test
    void testGenerateRandomNumber() {
        int randomNumber = racingGameModel.generateRandomNumber();
        for(int i = 0; i < 10000; i++) {
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }

    @DisplayName("우승자 잘 판별하는지 테스트")
    @Test
    void testGenerateWinner() {
        Car one = new Car("one");
        Car two = new Car("two");
        Car three = new Car("three");
        Car[] cars = new Car[3];
        cars[0] = one;
        cars[1] = two;
        cars[2] = three;
        //모두 거리 같은 경우
        Car[] winners = racingGameModel.generateWinner(cars);
        assertEquals("one", winners[0].getName());
        assertEquals("two", winners[1].getName());
        assertEquals("three", winners[2].getName());
        //2명이 거리 같은데 작은 경우
        cars[0].forward();
        winners = racingGameModel.generateWinner(cars);
        assertEquals("one", winners[0].getName());
        //2명이 거리 같은데 큰 경우
        cars[1].forward();
        cars[1].forward();
        cars[2].forward();
        cars[2].forward();
        winners = racingGameModel.generateWinner(cars);
        assertEquals("two", winners[0].getName());
        assertEquals("three", winners[1].getName());

        //1명만 큰 경우
        cars[1].forward();
        winners = racingGameModel.generateWinner(cars);
        assertEquals("two", winners[0].getName());

    }


}
