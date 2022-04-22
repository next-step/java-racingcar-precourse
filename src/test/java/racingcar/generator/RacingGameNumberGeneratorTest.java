package racingcar.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.Conditions;

class RacingGameNumberGeneratorTest {

    @Test
    @DisplayName("0~9 사이의 랜덤값을 생성한다.")
    void generate01() {
        // given
        // when
        NumberGenerator numberGenerator = new RacingGameNumberGenerator();
        Integer randomValue = numberGenerator.generate();

        // then
        Assertions.assertAll(
                () -> Assertions.assertTrue(randomValue >= Conditions.RACING_NUMBER_MIN),
                () -> Assertions.assertTrue(randomValue <= Conditions.RACING_NUMBER_MAX)
        );
    }
}