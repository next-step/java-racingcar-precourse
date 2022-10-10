package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @DisplayName("랜덤 값이 0-9로 생성되는 지 테스트")
    @Test
    void 랜덤값생성_테스트() {
        Player player = new Player(new Car(new CarName("test")));

        int movementScore = player.createMovementScore();
        assertTrue(  movementScore >= Player.MIN_NUMBER && movementScore <= Player.MAX_NUMBER);
    }
}
