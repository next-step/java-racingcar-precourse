package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarNameTest {

    private static final String INVALID_NAME_MESSAGE = "차량 이름을 5자리 이하로 입력해 주세요.";

    @Test
    void 이름_5자리_이하() {
        assertThat(new CarName("하스").getName()).isEqualTo("하스");
        assertThat(new CarName("에스턴마틴").getName()).isEqualTo("에스턴마틴");
        invalidName(null);
        invalidName("");
        invalidName("레이싱포인트");
    }

    private void invalidName(String name) {
        assertThat(catchThrowable(() -> new CarName(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_MESSAGE);
    }

}