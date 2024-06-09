package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void Car_생성() {
        // given
        String name = "TestCar";
        // when
        Car car = new Car(name);
        // then
        assertEquals(name, car.getName());
        assertEquals(0, car.getPosition());
    }


    @Test
    void 전진() {
        // given
        Car car = new Car("testCar");
        // when
        car.moveForward();
        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
