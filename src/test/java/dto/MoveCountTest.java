package dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCountTest {

    @Test
    void moveCount() {
        // 이동 횟수가 범위에서 벗어날 경우
        assertThrows(IllegalArgumentException.class, () -> new MoveCount("0"));
        assertThrows(IllegalArgumentException.class, () -> new MoveCount("10001"));

        // 이동 횟수가 숫자가 아닐 경우
        assertThrows(IllegalArgumentException.class, () -> new MoveCount("asdf"));
        assertThrows(IllegalArgumentException.class, () -> new MoveCount("1a"));

        // 정상 케이스
        MoveCount moveCount = new MoveCount(1);
        assertEquals(1, moveCount.count());

        moveCount = new MoveCount(100);
        assertEquals(100, moveCount.count());
    }

}