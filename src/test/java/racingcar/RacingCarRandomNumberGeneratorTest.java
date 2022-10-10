package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @author SeongRok.Oh
 * @since 2022/10/09
 */
public class RacingCarRandomNumberGeneratorTest {

    @DisplayName("RacingCar 랜덤 숫자 생성 0 - 9 까지 범위의 숫자 테스트")
    @RepeatedTest(30)
    void generate() {
        int randomNumber = RacingCarRandomNumberGenerator.generate();

        Assertions.assertThat(randomNumber)
                .isGreaterThan(-1)
                .isLessThan(10);
    }
}
