package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class RacingCarNameTest {

    @DisplayName("RacingCarName 생성 테스트")
    @Nested
    class CreateTest {

        @ParameterizedTest(name = "\"{arguments}\"로 RacingCarName을 생성할 수 있다.")
        @ValueSource(strings = {"a", "abcde"})
        void createSuccessTest(final String name) {
            assertThatNoException()
                    .isThrownBy(() -> new RacingCarName(name));
        }

        @ParameterizedTest(name = "\"{arguments}\"로 RacingCarName을 생성할 수 없다.")
        @ValueSource(strings = {"abcdef", " "})
        @NullAndEmptySource
        void createFailTest(final String name) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new RacingCarName(name));
        }
    }

}