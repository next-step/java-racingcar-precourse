package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 IllegalArgumentException를 발생시킨다.")
    void convertStringTryTimeToIntegerExceptionTest() {
        assertThatThrownBy(() -> {
            new Round("A");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 숫자로 입력해주세요!");
    }

    @Test
    @DisplayName("시도 횟수를 String에서 Integer 타입으로 변환하여 필드에 저장한다.")
    void convertStringTryTimeToIntegerTest() {
        Round round = new Round("3");
        int tryTime = round.getTryTime();
        assertThat(tryTime)
                .isInstanceOf(Integer.class)
                .isEqualTo(3)
                .isBetween(1, 10);
    }

    @Test
    @DisplayName("시도 횟수가 1 미만인 경우 IllegalArgumentException를 발생시킨다.")
    void validateMinRoundTest() {
        assertThatThrownBy(() -> {
            new Round("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 이상의 시도 횟수를 입력해주세요!");
    }

    @Test
    @DisplayName("시도 횟수가 10이 넘는 경우 IllegalArgumentException를 발생시킨다.")
    void validateMaxRoundTest() {
        assertThatThrownBy(() -> {
            new Round("11");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 10 이하의 시도 횟수를 입력해주세요!");
    }
}