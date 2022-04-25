package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    public void 자동차_이름은_다섯글자_이하() throws Exception {
        // given
        String pass = "pass";
        String exception = "exception";
        // when
        // then
        CarName carName1 = new CarName(pass);
        assertThatThrownBy(() -> {
            CarName carName2 = new CarName(exception);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
