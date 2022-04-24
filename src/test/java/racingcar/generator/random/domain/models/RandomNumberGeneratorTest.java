package racingcar.generator.random.domain.models;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.random.domain.errors.NumberGeneratorErrors;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤값 생성 도메인 객체를 생성한다.")
    @Test
    void create_number_generator_domain() {
        // given: none

        // when, then
        assertThatCode(() -> RandomNumberGenerator.generateNumberInRangeInclusively(1, 1))
                .doesNotThrowAnyException();
    }

    @DisplayName("랜덤값 생성 도메인 객체 생성 시, startInclusive 값이 endInclusive 보다 큰 경우, 예외가 발생한다.")
    @Test
    void create_number_generator_domain_startInclusive_greater_than_endInclusive() {
        // given
        int startInclusive = 10;
        int endInclusive = 9;

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> RandomNumberGenerator.generateNumberInRangeInclusively(startInclusive, endInclusive))
                .withMessage(NumberGeneratorErrors.NUMBER_GENERATOR_START_GREATER_THAN_END_INCLUSIVE);
    }
}