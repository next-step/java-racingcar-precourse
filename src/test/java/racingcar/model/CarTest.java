package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_이름_설정_테스트() {
        // given

        // when
        Car car = new Car("pobi");
        // then
        assertThat(car.getCarName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_전진_횟수_증가() {
        // given
        Car car = new Car("pobi");
        // when
        car.addMoveCnt();
        // then
        assertThat(car.getMoveCnt()).isEqualTo(1);
    }
}
