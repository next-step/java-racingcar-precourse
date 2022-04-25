package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    public void 자동차_이름은_5글자를_초과할_수_없다() {
        //given & when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new CarName("carnamess");
        });
        //then
        assertThat(exception).hasMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

}