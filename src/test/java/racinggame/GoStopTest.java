package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoStopTest {

    @Test
    void 전진_정지() {
        Car car = new Car();
        boolean go = car.goStopCheck(4);
        assertThat(go).isTrue();

    }
}
