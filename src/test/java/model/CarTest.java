package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("Car CLASS 생성 Test")
    public void Car_CLASS_생성_TEST(){
        //given
        Car car = new Car("테스트");

        //when

        //then
        assertThat(car.getName()).isEqualTo("테스트");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car CLASS 전진 Test")
    public void Car_전진_TEST(){
        //given
        Car car = new Car("테스트");

        //when
        car.advance(2);
        car.advance(3);
        car.advance(4);
        car.advance(5);

        //then
        assertThat(car.getPosition()).isEqualTo(2);

    }

}