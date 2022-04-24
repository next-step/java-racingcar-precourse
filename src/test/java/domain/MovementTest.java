package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovementTest {

    @ParameterizedTest
    @CsvSource(value = {"-10, -1, 10, 15, 19"})
    @DisplayName("FORWARD_STOP_범위_예외_확인")
    public void FORWARD_STOP_범위_예외_확인(int condition) {
        Movement movement = new Movement(0);
        assertThrows(IllegalArgumentException.class, () -> {
            movement.getMovementStatus(condition);
        });
    }

    @ParameterizedTest
    @CsvSource({"0,STOP", "3,STOP", "4,FORWARD", "9,FORWARD"})
    @DisplayName("FORWARD_STOP_범위_조건_확인")
    public void FORWARD_STOP_범위_조건_확인(int conditionNumber, MovementStatus status) {
        Movement movement = new Movement(0);
        assertThat(movement.getMovementStatus(conditionNumber)).isEqualTo(status);
    }

    @ParameterizedTest
    @CsvSource({"1,2", "9,10", "14,15", "20,21"})
    @DisplayName("앞으로_이동_테스트")
    public void 앞으로_이동_테스트(int initPosition, int nextPosition) {
        Movement movement = new Movement(initPosition);
        movement.forward();
        assertThat(movement.getPosition()).isEqualTo(nextPosition);
    }

    @ParameterizedTest
    @CsvSource({"0,0,0", "0,0,3", "0,1,4", "0,1,9"})
    @DisplayName("이동_결정_테스트")
    public void 이동_결정_테스트(int initPosition, int nextPosition, int randomForMovement) {
        Movement movement = new Movement(initPosition);
        movement.executeForwardOrStop(randomForMovement);
        assertThat(movement.getPosition()).isEqualTo(nextPosition);
    }

}
