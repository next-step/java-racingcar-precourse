package racingcar.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LabTest {
    @Test
    void 횟수_기본생성자_검증_테스트() {
        assertThatThrownBy(Lab::new)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 시도할 회수 입력값이 존재하지 않습니다.");
    }

    @Test
    void 횟수_입력값미전달_검증_테스트() {
        assertThatThrownBy(() -> new Lab(""))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 시도할 회수 입력값이 존재하지 않습니다.");
    }

    @Test
    void 횟수_입력값_숫자유형_검증_테스트() {
        assertThatThrownBy(() -> new Lab("!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도할 회수는 숫자만 입력 가능합니다.");
    }

    @Test
    void 횟수_1이상_입력값_검증_테스트() {
        assertThatThrownBy(() -> new Lab("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 시도할 회수는 1이상의 숫자만 입력 가능합니다.");
    }
}
