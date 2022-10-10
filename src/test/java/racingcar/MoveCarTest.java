package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.constants.ErrorConst.DISTANCE_OUT_OF_RANGE;

public class MoveCarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("sally");
    }

    @Test
    void 랜덤_숫자_4일때_이동() {
        int distance = 4;
        int originalPosition = car.getPosition();
        car.move(distance);
        int movedPosition = car.getPosition();
        assertThat(movedPosition).isEqualTo(originalPosition+distance);
    }

    @Test
    void 랜덤_숫자_9일때_이동() {
        int distance = 9;
        int originalPosition = car.getPosition();
        car.move(distance);
        int movedPosition = car.getPosition();
        assertThat(movedPosition).isEqualTo(originalPosition+distance);
    }

    @Test
    void 랜덤_숫자_10일때_에러발생() {
        int distance = 10;
        assertThatThrownBy(()->{
            car.move(distance);
        }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DISTANCE_OUT_OF_RANGE);
    }

    @Test
    void 랜덤_숫자_음수일때_에러발생() {
        int distance = -1;
        assertThatThrownBy(()->{
            car.move(distance);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DISTANCE_OUT_OF_RANGE);
    }

    @Test
    void 랜덤_숫자_3일때_중지() {
        int distance = 3;
        int originalPosition = car.getPosition();
        car.move(distance);
        int movedPosition = car.getPosition();
        assertThat(movedPosition).isEqualTo(originalPosition);
    }

    @Test
    void 랜덤_숫자_0일때_중지() {
        int distance = 0;
        int originalPosition = car.getPosition();
        car.move(distance);
        int movedPosition = car.getPosition();
        assertThat(movedPosition).isEqualTo(originalPosition);
    }
}
