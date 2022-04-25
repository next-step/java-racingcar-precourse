package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarsTest {

    @DisplayName("RacingCars 생성 테스트")
    @Test
    void createTest() {

        // given
        String names = "test,sam,kim";

        // when
        RacingCars racingCars = RacingCars.createRacingCarsFromInput(names);

        // then
        assertNotNull(racingCars);
    }

    @DisplayName("RacingCars 생성 실패 테스트")
    @Test
    void createFailTest() {

        // given
        String names = "test";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCars.createRacingCarsFromInput(names));
    }
}
