package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberOfRoundTest {
    @Test
    @DisplayName("숫자만 입력받은 경우")
    void onlyNumberInput(){
        assertThat(new NumberOfRound("5")).isNotNull();
    }

    @Test
    @DisplayName("문자를 입력받은 경우")
    void StringInput(){
        assertThatIllegalArgumentException().isThrownBy(()-> new NumberOfRound("NextStep"));
    }

    @Test
    @DisplayName("공백을 입력받은 경우")
    void EmptyInput(){
        assertThatIllegalArgumentException().isThrownBy(()-> new NumberOfRound("      "));
    }
}
