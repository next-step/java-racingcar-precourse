package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacerTest {
    @DisplayName("랜덤 값이 0-9로 생성되는 지 테스트")
    @Test
    void hasCorrectMovementScoreRange() {
        Racer racer = new Racer(new Car(new CarName("test")));

        int movementScore = racer.createMovementScore();
        assertTrue(  movementScore >= Racer.MIN_PICK_NUMBER && movementScore <= Racer.MAX_PICK_NUMBER);
    }

}
