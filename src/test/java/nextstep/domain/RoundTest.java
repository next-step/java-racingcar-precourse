package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RoundTest {

    @Test
    void 숫자_라운드() {
        Round round = new Round(1);
        assertThat(round.getRound()).isEqualTo(1);
    }

    @Test
    void 숫자가_아닌_문자() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Round("a"))
                .withMessage("[ERROR] 숫자가 아닌 문자는 입력받을 수 없습니다.");
    }

    @Test
    void 숫자인_문자() {
        Round round = new Round("1");
        assertThat(round.getRound()).isEqualTo(1);
    }

    @Test
    void 라운드_상한() {
    }
}