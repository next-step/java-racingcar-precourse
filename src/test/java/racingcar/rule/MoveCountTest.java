package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class MoveCountTest {

    @DisplayName("숫자 문자열로 생성할 수 있다")
    @Test
    void createMoveCountFromString() {
        //given
        String count = "5";

        //when
        Throwable thrown = catchThrowable(() -> MoveCount.fromString(count));

        //then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @DisplayName("숫자 문자열로 생성할 수 없으면 예외가 발생한다")
    @Test
    void throwExceptionWhenCannotParsingByNumbers() {
        //given
        String invalidCount = "a5";

        //when
        Throwable thrown = catchThrowable(() -> MoveCount.fromString(invalidCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 시도 횟수보다 작은 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenLessThanMin() {
        //given
        String invalidCount = "0";

        //when
        Throwable thrown = catchThrowable(() -> MoveCount.fromString(invalidCount));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 한다.");
    }

    @DisplayName("최대 시도 횟수보다 큰 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenGraterThanMax() {
        //given
        String invalidCount = "101";

        //when
        Throwable thrown = catchThrowable(() -> MoveCount.fromString(invalidCount));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 100 이하여야 한다.");
    }
}
