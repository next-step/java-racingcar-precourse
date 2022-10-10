package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CurrentPositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("숫자값을 가지는 CurrentPosition 객체를 생성한다.")
    void createCurrentPositionTest(int input) {
        CurrentPosition currentPosition = new CurrentPosition(input);
        assertThat(currentPosition.getValue()).isEqualTo(input);
    }

    @Test
    @DisplayName("0보다 작은 위치를 만들 경우 예외 발생")
    void underZeroTest() {
        assertThatThrownBy(() -> new CurrentPosition(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "2,3", "3,4", "4,5"})
    @DisplayName("숫자를 1씩 증가시킬 수 있다.")
    void createCurrentPositionTest(int input, int output) {
        CurrentPosition currentPosition = new CurrentPosition(input);
        currentPosition.increasePosition();
        assertThat(currentPosition.getValue()).isEqualTo(output);
    }
}