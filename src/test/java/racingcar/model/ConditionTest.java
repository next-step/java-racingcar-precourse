package racingcar.model;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 9})
    void 전진_조건_검증(int number) {
        CarStatus status = Condition.getStatus(number);

        assertThat(status).isEqualTo(CarStatus.GO);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 스톱_조건_검증(int number) {
        CarStatus status = Condition.getStatus(number);

        assertThat(status).isEqualTo(CarStatus.STOP);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void 랜덤_숫자_검증(int number) {
        ThrowableAssert.ThrowingCallable outOfRangeNumber = () -> Condition.validate(number);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(outOfRangeNumber);
    }
}