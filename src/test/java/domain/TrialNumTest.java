package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TrialNumTest {
    @DisplayName("사용자는 몇 번의 이동을 할 것인지 입력할 수 있다.")
    @Test
    void inputUserTryCount() throws Exception{

        String userInput = "5";
        TrialNum tryCount = new TrialNum(userInput);

        Assertions.assertThat(tryCount.getTrialNum()).isEqualTo(5);
    }

    @DisplayName("이동할 횟수는 자연수여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0","ㄷㄷ","!@","-1","은"})
    void isNaturalNumberValidate(String input) throws Exception{

        Assertions.assertThatThrownBy(() -> new TrialNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동할 횟수는 자연수여야 한다.");
    }
}
