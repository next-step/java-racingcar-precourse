package racingcar.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exceptions.IllegalArgumentException;

public class CarNameTest {

    @Test
    @DisplayName("자동차의 이름이 올바르게 출력되는가")
    void name() {
        String name = "하나둘셋";
        assertThat(new CarName(name).get()).isEqualTo(name);
    }

    @Test
    @DisplayName("포함하지 말아야 할 구분자를 포함했을 때, 오류가 발생하는가")
    void error_contain_separator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                CarName name = new CarName("po,");
            })
            .withMessageContaining(", 는 사용할 수 없어요.");

    }

    @Test
    @DisplayName("길이를 초과했을 때, 오류가 발생하는가")
    void error_over_length() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                CarName name = new CarName("일이삼사오육");
            })
            .withMessageContaining("자동차 이름은 5자 이내 이어야 해요.")
            .withMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("공백을 포함했을 때, 오류가 발생하는가")
    void error_contain_whitespace() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                CarName name = new CarName(" abc");
            })
            .withMessageContaining("자동차 이름에 공백은 없어야 해요.")
            .withMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("이름이 없을 때, 오류가 발생하는가")
    void error_empty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                CarName name = new CarName("");
            })
            .withMessageContaining("자동차의 이름이 필요해요.")
            .withMessageContaining("[ERROR]");

    }
}
