package racingcar.domain.racing.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private static final String ONE_CAR = "하나";
    private static final String THREE_CARS = "aaa,bbb,ccc";
    private static final String FIVE_CARS = "111,222,333,444,555";
    private static final String FIVE_CARS_WITH_SPACE = "  111, 222, 333, 444, 555   ";

    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int FIVE = 5;

    @Test
    @DisplayName("쉼표 기준으로 구분하여 n대의 자동차를 생성한다")
    void 쉼표_기준으로_구분하여_n대의_자동차를_생성한다() {
        assertThat(Cars.from(ONE_CAR).count()).isEqualTo(ONE);
        assertThat(Cars.from(THREE_CARS).count()).isEqualTo(THREE);
        assertThat(Cars.from(FIVE_CARS).count()).isEqualTo(FIVE);
        assertThat(Cars.from(FIVE_CARS_WITH_SPACE).count()).isEqualTo(FIVE);
    }
}
