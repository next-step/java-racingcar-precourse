package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LapTest {
    @DisplayName("lap이 1씩 증가하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "9,10"}, delimiter = ',')
    void increment(Integer start, Integer expected) {
        Lap lap = new Lap(start);

        lap.increment();

        assertThat(lap.getLap()).isEqualTo(expected);
    }

    @DisplayName("lap 간 크기 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,-1", "10,9,1", "3,3,0"}, delimiter = ',')
    void compareTo(Integer val, Integer val2, Integer expected) {
        Lap lap = new Lap(val);
        Lap lap2 = new Lap(val2);

        int result = lap.compareTo(lap2);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("lap 숫자가 아닐 시 에러")
    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class, () -> new Lap("abc"));
    }
}
