package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingRoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "-100", "이백", "삼", "-0"})
    void 시도_회수가_양의_정수가_아니면_에러_발생(String round) {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingRound.of(round))
                .withMessage("[ERROR] 시도 회수는 양의 정수로 입력하셔야 합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "00", "001", "012", "010"})
    void 시도_회수가_0이거나_0으로_시작하면_에러_발생(String round) {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingRound.of(round))
                .withMessage("[ERROR] 시도 회수는 0이거나 0으로 시작할 수 없습니다");
    }

}
