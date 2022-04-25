package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    Engine engine;

    @BeforeEach
    void init() {
        engine = RandomEngine.getInstance();
    }

    @Test
    public void 자동차는_0이상_주행거리를_가진다() throws Exception {
        // given
        Car car1 = new Car(engine, "car1", 0);
        // when
        car1.drive();
        // then
        assertThat(car1.getDistanceDriven() > -1).isTrue();
    }

    @Test
    public void 자동차는_5자이하_이름을_가진다() throws Exception {
        // when
        Car car1 = new Car(engine, "이름1", 0);
        // then
        assertThatThrownBy(() -> {
            Car car2 = new Car(engine, "이름1234", 0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
