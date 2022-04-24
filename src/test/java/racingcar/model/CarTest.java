package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.TestConstants.RIGHT_NAME;
import static racingcar.TestConstants.WRONG_NAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @Test
    void testToString() {
        assertThat(car.toString()).isEqualTo(RIGHT_NAME + " : ");
    }

    @Test
    void setName() {
        assertThat(car.getName()).isEqualTo(RIGHT_NAME);
    }

    @Test
    void NegativeSetName() {
        assertThatIllegalArgumentException().isThrownBy(() -> car.setName(WRONG_NAME));
    }

    @Test
    void setMoveCount() {
        car.setMoveCount(car.getMoveCount() + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2, 100})
    void NegativeSetMoveCount(int wrong_value) {
        assertThatIllegalArgumentException().isThrownBy(() -> car.setMoveCount(wrong_value));
    }

    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo(RIGHT_NAME);
    }

    @Test
    void getMoveCount() {
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @BeforeEach
    void setUp() {
        car = new Car(RIGHT_NAME);
    }
}