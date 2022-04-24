package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarMoveServiceTest {

    @DisplayName("몇번을 이동할지 결정한다.")
    @Test
    void move() {
        InputCarService inputCarService = new InputCarService("123,456");
        CarMoveService carMoveService = new CarMoveService("5");
        carMoveService.move(inputCarService);
        int[] moveArr = carMoveService.getCarMoveCount();
        assertTrue(moveArr[0] >= 0);
        assertTrue(moveArr[0] <= 5);
        assertTrue(moveArr[1] >= 0);
        assertTrue(moveArr[1] <= 5);
    }

    @DisplayName("이동여부를 결정한다.")
    @Test
    void isMove() {
        CarMoveService carMoveService = new CarMoveService("1");
        assertTrue(carMoveService.isMove() >= 0);
        assertTrue(carMoveService.isMove() <= 1);
    }
}