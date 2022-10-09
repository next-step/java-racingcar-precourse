package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("임의의 수 생성 기능 관련")
class RandomNumberGeneratorTest {
    @DisplayName("0 ~ 9 사이의 숫자를 생성한다.")
    @Test
    void generate() {
        // given
        NumberGenerator numberGenerator = RandomNumberGenerator.instance();

        // when
        int number = numberGenerator.generate();

        // then
        assertThat(number).matches(n -> 0 <= n && n <= 9);
    }
}
