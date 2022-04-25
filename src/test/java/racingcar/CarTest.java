package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.FailureMovement;
import racingcar.model.SuccessMovement;

class CarTest {

    @Test
    void move의_결과가_4이상이면_자동차_객체의_위치가_1만큼_이동한다() {
        // given
        Car car = new Car("pobi");
        int beforePosition = car.position().length();

        // when
        car.move(new SuccessMovement());
        int afterPosition = car.position().length();

        // then
        Assertions.assertThat(beforePosition + 1).isEqualTo(afterPosition);
    }

    @Test
    void move의_결과가_4미만이면_자동차_객체의_위치가_이동하지_않는다() {
        // given
        Car car = new Car("pobi");
        int beforePosition = car.position().length();

        // when
        car.move(new FailureMovement());
        int afterPosition = car.position().length();

        // then
        Assertions.assertThat(beforePosition).isEqualTo(afterPosition);
    }

    @Test
    void 자동차_객체의_위치는_대시로_표현된다() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(new SuccessMovement());
        car.move(new SuccessMovement());
        String position = car.position();

        // then
        Assertions.assertThat(position).isEqualTo("--");
    }
}