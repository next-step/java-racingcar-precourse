package nextstep.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"b","gpark"})
    void 자동차_생성(String name) {
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 자동차_이동() {
        Car car = new Car("car");
        MoveResult result = car.move(4);
        assertThat(result).isEqualTo(new MoveResult("car", 1));
    }
}