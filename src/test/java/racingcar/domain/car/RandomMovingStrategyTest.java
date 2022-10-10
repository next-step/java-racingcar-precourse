package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.GivenIntGenerator;

class RandomMovingStrategyTest {
    @ParameterizedTest(name = "랜덤 숫자 생성기는 null이 아니어야 한다.")
    @NullSource
    void notNull(RandomIntGenerator generator) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RandomMovingStrategy(generator))
                .withMessage("The random int generator should not be null!");
    }

    @DisplayName("랜덤 숫자 생성기를 받아 생성된다.")
    @Test
    void construct() {
        final RandomIntGenerator generator = new GivenIntGenerator(1);
        assertThatNoException()
                .isThrownBy(() -> new RandomMovingStrategy(generator));
    }

    @ParameterizedTest(name = "생성된 숫자는 0 ~ 9 사이여야 한다. 생성된 숫자: {0}")
    @ValueSource(ints = {-1, 10})
    void illegalInt(int illegalInt) {
        final RandomIntGenerator generator = new GivenIntGenerator(illegalInt);
        final RandomMovingStrategy strategy = new RandomMovingStrategy(generator);
        assertThatIllegalStateException()
                .isThrownBy(() -> strategy.move())
                .withMessage("The value should be between 0 and 9!");
    }

    @ParameterizedTest(name = "생성된 숫자가 {0}이면 {1}칸 전진한다.")
    @CsvSource({
            "0,0",
            "1,0",
            "2,0",
            "3,0",
            "4,1",
            "5,1",
            "6,1",
            "7,1",
            "8,1",
            "9,1"
    })
    void move(int givenInt, int expectedValue) {
        final RandomIntGenerator generator = new GivenIntGenerator(givenInt);
        final RandomMovingStrategy strategy = new RandomMovingStrategy(generator);
        final Distance expectedMovement = new Distance(expectedValue);

        final Distance actualMovement = strategy.move();

        assertThat(actualMovement).isEqualTo(expectedMovement);
    }
}
