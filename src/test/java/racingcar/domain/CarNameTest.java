package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void 자동차_이름이_5자를_초과하면_에러_발생(){
        Assertions.assertThatThrownBy(() -> new CarName("붕붕쌩썡씽씽이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자를 초과할 수 없습니다.");
    }
}
