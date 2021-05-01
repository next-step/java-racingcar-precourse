package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarTest {

    @Test
    @DisplayName("자동차 생성 - 이름 입력")
    void contractor_name() {
        Car car = new Car("  하스      ");
        assertThat(car.getName()).isEqualTo("하스");

        car = new Car("에스턴마틴");
        assertThat(car.getName()).isEqualTo("에스턴마틴");

        assertThat(catchThrowable(() -> new Car(null)))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("차량 이름을 5자리 이하로 입력해 주세요.");

        assertThat(catchThrowable(() -> new Car("")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량 이름을 5자리 이하로 입력해 주세요.");

        assertThat(catchThrowable(() -> new Car("   ")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량 이름을 5자리 이하로 입력해 주세요.");

        assertThat(catchThrowable(() -> new Car("레이싱포인트")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량 이름을 5자리 이하로 입력해 주세요.");
    }

}