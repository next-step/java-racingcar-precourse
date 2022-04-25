package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarPosition;

class OutputTest {
    @Test
    void 하이픈_위치_표시() {
        CarPosition carPosition = new CarPosition();
        carPosition.setPosition(5);
        String hyphenRoad = Output.getHyphenRoad(carPosition.getPosition());

        assertThat(hyphenRoad).isEqualTo("-----");
    }
}