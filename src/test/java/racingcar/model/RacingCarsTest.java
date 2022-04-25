package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingCarsTest {
    private static final String CAR_DUP_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private static final int MOVING_FORWARD = 4;

    @Test
    @DisplayName("자동차 이름은 중복될 수 없다.")
    void throw_error_with_duplicated_carname() {
        assertThatThrownBy(
            () -> new RacingCars(Arrays.asList(new Car("aaa"), new Car("aaa")))
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(CAR_DUP_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("모든 자동차가 레이스를 수행하고 난 뒤 결과를 리턴한다.")
    void race() {
        // given
        RacingCars racingCars = new RacingCars(Arrays.asList(new Car("aaa"), new Car("bbb")));
        RaceResult car1 = new RaceResult("aaa", 1);
        RaceResult car2 = new RaceResult("bbb", 1);

        assertRandomNumberInRangeTest(
            () -> {
                List<RaceResult> results = racingCars.race();
                assertAll(
                    () -> assertThat(results).isNotNull(),
                    () -> assertThat(results).contains(car1, car2)
                );
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
