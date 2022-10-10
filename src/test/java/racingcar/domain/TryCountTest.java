package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.domain.TryCount.MIN_COUNT;

class TryCountTest {
    static IntStream positiveIntegerStream() {
        int rangeSize = 10;
        return IntStream.range(1, rangeSize + 1);
    }

    @ParameterizedTest(name = "시도 회수 정상적으로 생성되는지 확인한다. [시도 회수 : {0}]")
    @MethodSource("positiveIntegerStream")
    void fromTest(int count) {
        // when
        TryCount tryCount = TryCount.from(count);

        //then
        assertThat(tryCount.getCount()).as("시도 회수 정상 대입 되었는지 확인")
                .isEqualTo(count);
    }

    @Test
    @DisplayName("최소 시도 회수 이하를 입력한 경우 IllegalArgumentException이 발생한다.")
    void exceptionTest() {
        // given
        int count = MIN_COUNT - 1;

        //then
        assertThatIllegalArgumentException().as("Exception 클래스 및 에러 메시지 일치 여부 확인")
                .isThrownBy(
                        // when
                        () -> TryCount.from(count)
                )
                .withMessage(String.format("시도 회수는 %d 이상만 입력 가능합니다.", MIN_COUNT));
    }
}