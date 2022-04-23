package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarHub;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarHubTest {

    @Test
    void init() {
        CarHub hub = new CarHub("pobi,woni,jun");

        assertThat(hub.getCars().size()).isEqualTo(3);
    }

    @Test
    void initFail() {
        assertThrows(IllegalArgumentException.class, () -> new CarHub("pobiii,woni,jun"));
    }
}
