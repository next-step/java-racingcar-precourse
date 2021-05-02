package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CarTest {

    @Test
    @DisplayName("자동차 생성, 이름 5자이하 테스트")
    void constructor() {
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
        assertThat(catchThrowable(() -> new Car(name))).isInstanceOf(IllegalArgumentException.class);
    }

}