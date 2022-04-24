package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * author : citizen103
 */
public class MovementTest {

    @Test
    void 값이_4이상이면_전진_Test() {
        // Given
        Movement movement = new Movement();

        // When
        movement.move();

        // Then
        assertThat(movement.isMovementSame(1)).isTrue();
        assertThat(movement.getHyphen()).isEqualTo("-");
    }

}
