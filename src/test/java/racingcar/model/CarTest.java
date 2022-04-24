package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차 생성 테스트")
    @Test
    void carCreateTest() {
        // given
        String name = "pobi";


        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이동 성공 테스트")
    @Test
    public void carMoveTest() {
        // given
        MovableStrategy movableStrategy = () -> RandomNumber.generate(4, 9) >= 4;
        Car car = new Car("pobi", movableStrategy);

        // when
        car.move();

        // then
        assertThat(car.curPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 이동 실패 테스트")
    @Test
    public void carMoveTestFail() {
        // given
        MovableStrategy movableStrategy = () -> RandomNumber.generate(1, 3) >= 4;
        Car car = new Car("pobi", movableStrategy);

        // when
        car.move();

        // then
        assertThat(car.curPosition()).isEqualTo(0);
    }

}
