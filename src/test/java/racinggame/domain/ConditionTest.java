package racinggame.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 9})
    @DisplayName("생성한 숫자가 4 이상이면 CarStatus.GO를 반환한다")
    void more_than_4_go(int number) {
        CarStatus status = Condition.getStatus(number);

        assertThat(status).isEqualTo(CarStatus.GO);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("생성한 숫자가 3 이하이면 CarStatus.STOP를 반환한다")
    void less_than_4_go(int number) {
        CarStatus status = Condition.getStatus(number);

        assertThat(status).isEqualTo(CarStatus.STOP);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("생성한 숫자가 0 ~ 9 사이를 만족하지 않으면 Exception이 발생한다.")
    void out_of_range_number(int number) {
        ThrowableAssert.ThrowingCallable outOfRangeNumber = () -> Condition.validate(number);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(outOfRangeNumber);
    }
}