package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarNameTest {

    @Test
    @DisplayName("자동차 이름 wrapper 테스트")
    void constructor() {
        assertThat(new CarName("하스").getName()).isEqualTo("하스");
        assertThat(new CarName("에스턴마틴").getName()).isEqualTo("에스턴마틴");
        invalidName(null);
        invalidName("");
        invalidName("레이싱포인트");
    }

    private void invalidName(String name) {
        assertThat(catchThrowable(() -> new CarName(name))).isInstanceOf(IllegalArgumentException.class);
    }

}