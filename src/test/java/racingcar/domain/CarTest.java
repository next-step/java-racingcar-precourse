package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void 자동차_객체_생성(){
        Car car = new Car("car");
        assertEquals("car", car.getName());
    }
}
