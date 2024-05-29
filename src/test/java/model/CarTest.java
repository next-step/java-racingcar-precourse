package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    Car car = new Car();

    @Test
    @DisplayName("이름 저장 및 조회 확인")
    public void checkGetterSetter() {
        car.setName("Pobi");

        Assertions.assertThat(car.getName()).isEqualTo("Pobi");
    }

    @Test
    @DisplayName("자동차 전진 기능 확인")
    public void move() {
        car.setPosition(1);
        car.move();

        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }
}
