package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarTest {

    private static final String INVALID_NAME_MESSAGE = "차량 이름을 5자리 이하로 입력해 주세요.";

    @Test
    @DisplayName("자동차 생성 - 이름 입력")
    void 자동차_생성_및_이름_5자리_이하() {
        Car car = new Car("  하스      ");
        assertThat(car.getName()).isEqualTo("하스");

        car = new Car("에스턴마틴");
        assertThat(car.getName()).isEqualTo("에스턴마틴");

        invalidName(null);
        invalidName("");
        invalidName("   ");
        invalidName("레이싱포인트");
    }

    private void invalidName(String name) {
        assertThat(catchThrowable(() -> new Car(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NAME_MESSAGE);
    }

}