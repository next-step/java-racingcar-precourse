package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class InputOutputTest {
    @Test
    @DisplayName("자동차의 이름 구분")
    void separateCarName() {
        assertThat(InputOutput.separateName("pobi,crong,honux")).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }
    
    @Test
    @DisplayName("이름이 5자 이하인지 검증")
    void name_5_less_than() {
        assertThat(InputOutput.checkLen("pobi")).isTrue();
        assertThat(InputOutput.checkLen("pobiaaa")).isFalse();
    }
}
