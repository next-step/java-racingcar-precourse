package racingcar.model.movement.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.movement.MovementStatus;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementStrategyTest {
    private RandomMovementStrategy randomMovementStrategy;

    @BeforeEach
    void setUp() {
        randomMovementStrategy = new RandomMovementStrategy(RandomMovementConfig.START_RANDOM_NUMBER,
                                                            RandomMovementConfig.END_RANDOM_NUMBER,
                                                            RandomMovementConfig.GREATER_THAN_OR_EQUAL_TO_STANDARD_NUMBER);
    }

    @Test
    @DisplayName("0에서 9사이의 random 값 1개를 구한다.")
    void pickRandomNumber() {
        // given

        // when
        int randomNumber = randomMovementStrategy.pickRandomNumber();

        // then
        assertThat(randomNumber)
                .isNotNegative()
                .isLessThanOrEqualTo(9)
                .isLessThan(10);
    }

    @Test
    @DisplayName("값이 4 이상일 경우 전진한다.")
    void go() {
        // given
        int randomNumber = 4;

        // when
        MovementStatus movementStatus = randomMovementStrategy.race(randomNumber);

        // then
        assertThat(movementStatus).isEqualTo(MovementStatus.GO);
    }

    @Test
    @DisplayName("값이 3 이하일 경우 멈춘다.")
    void stop() {
        // given
        int randomNumber = 3;

        // when
        MovementStatus movementStatus = randomMovementStrategy.race(randomNumber);

        // then
        assertThat(movementStatus).isEqualTo(MovementStatus.STOP);
    }

    @Test
    @DisplayName("random 값을 구해서 전진하거나 멈춘다.")
    void stopAndGo() {
        // given

        // when
        MovementStatus movementStatus = randomMovementStrategy.race();

        // then
        assertThat(movementStatus).isNotNull();
    }
}
