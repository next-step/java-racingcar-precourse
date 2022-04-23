package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarHubTest {

    @Test
    void init() {
        CarHub hub = new CarHub();
        hub.init("pobi", "woni", "jun");

        assertThat(hub.getCars().size()).isEqualTo(3);
    }

    @Test
    void initFail() {
        CarHub hub = new CarHub();

        assertThrows(IllegalArgumentException.class, () -> hub.init("pobiii", "woni", "jun"));
    }
}
