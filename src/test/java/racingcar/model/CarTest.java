package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("Car CLASS 생성 Test")
    public void Car_CLASS_생성_TEST() {
        //given
        Car car = new Car("테스트");

        //when

        //then
        assertThat(car.getName()).isEqualTo("테스트");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car CLASS 이동 Test")
    public void Car_이동_TEST() {
        //given
        Car car = new Car("테스트");

        //when
        car.move(2);
        car.move(3);
        car.move(4);
        car.move(5);

        //then
        assertThat(car.getPosition()).isEqualTo(2);
    }
}

