package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("toString이 원하는 포멧으로 출력되는지 확인")
    void to_string_테스트() {
        final Car car = new Car("테스트");
        car.drive(4);
        car.drive(4);
        car.drive(3);
        assertThat(car.toString()).isEqualTo("테스트 : --");
    }
}