package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    @DisplayName("1에서 9 사이의 난수가 발생하는지 테스트")
    void randomNumberTest() {

        for (int i = 0; i < 10000; i++) {
            // when
            Number randomNumber = Generator.randomNumber();

            // then
            assertThat(randomNumber.get()).isBetween(1, 9);
        }
    }
}
