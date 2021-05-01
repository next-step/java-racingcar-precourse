package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarNameTest {

    @Test
    void 이름_5자리_이하() {
        assertThat(new CarName("하스").getName()).isEqualTo("하스");
        assertThat(new CarName("에스턴마틴").getName()).isEqualTo("에스턴마틴");

        assertThat(catchThrowable(() -> new CarName(null)))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("차량 이름을 5자리 이하로 입력해 주세요.");

        assertThat(catchThrowable(() -> new CarName("")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량 이름을 5자리 이하로 입력해 주세요.");

        assertThat(catchThrowable(() -> new CarName("레이싱포인트")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량 이름을 5자리 이하로 입력해 주세요.");
    }

}