package game.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    void 자동차_이름_입력_오류(){

        assertThatThrownBy(() -> {
            RacingCars cars = new RacingCars("caaars");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            RacingCars cars = new RacingCars("");
        }).isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    void 자동차_이름_입력_테스트(){

        RacingCars cars = new RacingCars("car1,car2");
        System.out.println(cars.getCar());

    }

}