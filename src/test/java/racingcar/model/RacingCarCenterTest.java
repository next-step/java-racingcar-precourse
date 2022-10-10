package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarsDuplicationException;
import racingcar.exception.RacingCarsMaxSizeException;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("model - RacingCarCenter")
class RacingCarCenterTest {
    private final int testRepeat = 1000;

    private RacingCarCenter racingCarCenter;
    private RacingCar racingCar;
    private List<RacingCar> racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new ArrayList<>();
    }

    @Test
    @DisplayName("할당 가능한 레이상카 수를 초과하는 경우")
    void max_racing_car_test() {
        // When
        for (int i = 0; i < testRepeat; i++) {
            racingCars.add(new RacingCar("A"));
        }

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new RacingCarCenter(racingCars) )
                        .isInstanceOf(RacingCarsMaxSizeException.class)
        );
    }

    @Test
    @DisplayName("중복된 레이싱카 이름을 할당하는 경우")
    void valid_name_length_test() {
        // When
        for (int i = 0; i < 2; i++) {
            racingCars.add(new RacingCar("A"));
        }

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new RacingCarCenter(racingCars) )
                        .isInstanceOf(RacingCarsDuplicationException.class)
        );
    }
}