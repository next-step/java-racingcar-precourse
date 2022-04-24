package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.ErrorMessage.CAR_NAME_LENGTH_ERROR;

class CarNameTest {

    @Test
    void 자동차_이름을_5자리까지_허용() {
        String value = "kks91";
        assertThat(new CarName(value)).isEqualTo(new CarName(value));
    }

    @Test
    void 자동차_이름을_6자리_이상_입력하면_오류_발생() {
        assertThatThrownBy(() -> new CarName("kyoung1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_ERROR);
    }
}