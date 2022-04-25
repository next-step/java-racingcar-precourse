package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarTest {

    @DisplayName("RacingCar 생성 테스트")
    @Test
    void makeRacingCar() {

        // given & when
        RacingCar racingCar = RacingCar.createRacingCarWithDefaultStrategy("test");

        // then
        assertThat(racingCar).isNotNull();
    }

    @DisplayName("RacingCar 생성 실패 테스트")
    @Test
    void makeRacingCarFail() {

        // given
        final String invalidInput = "test12345";
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCar.createRacingCarWithDefaultStrategy(invalidInput));
    }

    @DisplayName("move() 성공 테스트")
    @Test
    void moveSuccessTest() {

        // given
        RacingCar racingCar = RacingCar.createRacingCarWithMovingStrategy("test", () -> true);

        // when & then
        assertThat(racingCar.getDistance()).isEqualTo(0);
        racingCar.move();
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @DisplayName("move() 실패 테스트")
    @Test
    void moveFailTest() {

        // given
        RacingCar racingCar = RacingCar.createRacingCarWithMovingStrategy("test", () -> false);

        // when & then
        assertThat(racingCar.getDistance()).isEqualTo(0);
        racingCar.move();
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }
}
