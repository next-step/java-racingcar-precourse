package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarPrecessTest {

    private final int ADVANCE_NUMBER = 8;
    private final int STOP_NUMBER = 2;

    private Racing racing = new Racing();

    @Test
    void 전진하려면_랜덤수가_4이상() {
        Car car = new Car();
        car.initAdvanceCount();
        racing.calcAdvanceCountByRandomNumber(car, ADVANCE_NUMBER);
        assertThat(car.getNowAdvanceCount()).isEqualTo(1);
    }

    @Test
    void 정지하려면_랜덤수가_3이하() {
        Car car = new Car();
        car.initAdvanceCount();
        racing.calcAdvanceCountByRandomNumber(car, STOP_NUMBER);
        assertThat(car.getNowAdvanceCount()).isEqualTo(0);
    }

}
