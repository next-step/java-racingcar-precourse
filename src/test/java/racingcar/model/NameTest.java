package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void 자동차_이름은_5자_이하여야_한다() {
        int carNameLength = Name.valueOf("name1").get().length();
        assertThat(carNameLength).isEqualTo(5);
    }

    @Test
    void 자동차_이름이_5자를_초과하면_예외를_던진다() {
        assertThatThrownBy(() -> Name.valueOf("abcde6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 5자 이하의 자동차 이름을 입력해주세요.");
    }

}
