package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차를 앞으로 한 칸 전진시킨다.")
    @Test
    void move() throws Exception {
        //given
        Car car = new Car("kia");

        //when
        car.move(7);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차를 앞으로 한 칸 전진 시키는데, 주어진 난수가 4 미만이면 전진하지 않는다.")
    @Test
    void moveWithRandomNumberLessThanFour() throws Exception {
        //given
        Car car = new Car("kia");

        //when
        car.move(3);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
