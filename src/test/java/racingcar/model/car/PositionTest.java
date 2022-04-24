package racingcar.model.car;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

    private Position position;

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 자동차_이동_여부(boolean canGoForward) {
        assertEquals(new Position(canGoForward).isMove(), canGoForward);
    }
}
