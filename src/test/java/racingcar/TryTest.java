package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.TryCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TryTest {

    @Test
    @DisplayName("시도 회수 입력")
    void input_TryCount() {
        TryCount count = new TryCount("3");
        assertThat(count.getCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("시도 회수 입력 값의 정수 검증")
    void input_TryCount_Int_Valid() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TryCount("삼"))
                .withMessageContaining("숫자");
    }

    @Test
    @DisplayName("시도 회수 입력 값의 소수 검증")
    void input_TryCount_Float_Test() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TryCount("0.3"))
                .withMessageContaining("숫자");
    }


    @Test
    @DisplayName("시도 회수 입력 값의 양수 검증")
    void input_TryCount_Positive_Valid() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new TryCount("0"))
                .withMessageContaining("0보다 커야 한다.");
    }


}
