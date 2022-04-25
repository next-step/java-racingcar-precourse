package racingcar.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.CarsTest;
import racingcar.model.vo.Car;
import racingcar.model.vo.InputNumber;
import racingcar.model.vo.RandomNumber;
import racingcar.service.RacingService;

import java.util.Arrays;

class RacingServiceImplTest {

    private Cars cars;
    private InputNumber inputNumber;
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        cars = new Cars("car,race,test");
        inputNumber = new InputNumber("5");
        racingService = new RacingServiceImpl(cars, inputNumber);
    }

    @Test
    @DisplayName("레이스 시작")
    void raceRunTest() {
        racingService.racing();
        for (Car car : cars.toList()) {
            System.out.println("car.getCarName().getName() = " + car.getCarName().getName());
            System.out.println("car.getCarPosition().getPosition() = " + car.getCarPosition().getPosition());
            System.out.println("car.getCarPosition().isPosition() = " + car.getCarPosition().isPosition());
        }
    }

    @Test
    @DisplayName("레이스 시작")
    void raceResultTest() {
        racingService.racing();
        racingService.raceResult();
    }

    @Test
    void winnerCar() {
        racingService.racing();
        racingService.raceResult();
        racingService.winner();
    }
}