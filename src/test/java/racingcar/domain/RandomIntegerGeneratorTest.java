package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.RandomIntegers;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomIntegerGeneratorTest {
    @DisplayName("숫자_사이의_정수를_생성한다")
    @ParameterizedTest
    @MethodSource("숫자의_범위를_제공한다")
    void 숫자_사이의_정수를_생성한다(int inclusiveStart, int inclusiveEnd) {
        RandomIntegerGenerator generator = new RandomIntegerGenerator(inclusiveStart, inclusiveEnd);
        int integer = generator.pickRandomIntegerInRange();

        assertThat(integer).isBetween(inclusiveStart, inclusiveEnd);
    }

    static Stream<Arguments> 숫자의_범위를_제공한다() {
        return Stream.of(
                Arguments.of(0, 9),
                Arguments.of(0, 0),
                Arguments.of(-100, 100)
        );
    }

    @DisplayName("한_개_이상의_숫자_사이의_정수를_생성한다")
    @ParameterizedTest
    @MethodSource("숫자의_범위와_생성_개수를_제공한다")
    void 한_개_이상의_숫자_사이의_정수를_생성한다(int inclusiveStart, int inclusiveEnd, int count) {
        RandomIntegerGenerator generator = new RandomIntegerGenerator(inclusiveStart, inclusiveEnd);
        RandomIntegers integers = generator.pickRandomIntegersInRange(count);

        assertThat(count).isEqualTo(integers.size());

        for (int idx = 0; idx < count; idx++) {
            assertThat(integers.get(idx)).isBetween(inclusiveStart, inclusiveEnd);
        }
    }

    static Stream<Arguments> 숫자의_범위와_생성_개수를_제공한다() {
        return Stream.of(
                Arguments.of(0, 9, 5),
                Arguments.of(0, 0, 1),
                Arguments.of(-100, 100, 100)
        );
    }

    @DisplayName("잘못된_입력값이_들어온_경우_숫자_생성_실패_테스트")
    @ParameterizedTest(name = "{index}: {3}")
    @MethodSource("잘못된_숫자의_범위와_생성_개수를_제공한다")
    void 잘못된_입력값이_들어온_경우_숫자_생성_실패_테스트(int inclusiveStart, int inclusiveEnd, int count, String exceptionMessage) {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> {
                    RandomIntegerGenerator generator = new RandomIntegerGenerator(inclusiveStart, inclusiveEnd);
                    generator.pickRandomIntegersInRange(count);
                });
        assertThat(e.getMessage()).isEqualTo(exceptionMessage);
    }

    static Stream<Arguments> 잘못된_숫자의_범위와_생성_개수를_제공한다() {
        return Stream.of(
                Arguments.of(-10, 10, 0, "한 개 이상의 숫자를 생성해야 합니다."),
                Arguments.of(20, 0, 3, "종료값이 시작값 보다 작을수 없습니다.")
        );
    }
}
