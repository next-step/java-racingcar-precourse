package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositionTest {

    @Test
    void 포지션생성_테스트() {
        Position positon = new Position(3);
        assertEquals(positon, new Position(3));
    }

    @Test
    void 포지션값_유효성체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Position(-1);
        });
    }

    @Test
    void move테스트() {
        Position position = new Position(2);
        position.move();
        assertEquals(position.getPosition(), new Position(3).getPosition());
    }
}
