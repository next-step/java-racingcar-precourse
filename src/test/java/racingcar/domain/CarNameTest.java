package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {
    @Test
    @DisplayName("5글자 이하인 경우 정상적으로 생성된다.")
    void make_name_well_5_or_less() {
        CarName carName = new CarName("apple");
        assertThat(carName.getName()).isEqualTo("apple");
    }

    @Test
    @DisplayName("5글자 초과인 경우 IllegalArgumentException 발생")
    void make_name_fail_greater_than_5() {
        assertThatThrownBy(() -> new CarName("apples"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 이름을 5자 이하로 입력해 주세요.");
    }

}
