package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConditionTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진_조건_테스트(int number) {
        CarStatus status = Condition.getStatus(number);

        assertThat(status).isEqualTo(CarStatus.GO);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 스톱_조건_테스트(int number) {
        CarStatus status = Condition.getStatus(number);

        assertThat(status).isEqualTo(CarStatus.STOP);
    }

}