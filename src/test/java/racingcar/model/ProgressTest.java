package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.Constants;

class ProgressTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 123})
    @DisplayName("fromTest:[success]")
    void from(int input) {
        //when
        Progress from = Progress.from(input);
        //then
        assertThat(from).isInstanceOf(Progress.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -123})
    @DisplayName("fromTest (음수 입력 예외):[failure]")
    void from_NegativeInputException(int input) {
        //when&then
        assertThatThrownBy(() -> Progress.from(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.COMMON_ERROR_HEADER.concat("음수 상태 값은 허용되지 않습니다."));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 123})
    @DisplayName("getProgress:[success]")
    void getProgress(int input) {
        //when
        Progress from = Progress.from(input);
        //then
        assertThat(from.getProgress()).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource({"1,2", "20,21"})
    @DisplayName("getProgress:[success]")
    void increaseProgress(int input, int expected) {
        //given
        int i = 1;
        Progress from = Progress.from(i);
        //when
        from = from.increaseProgress(input);
        //then
        assertThat(from.getProgress()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -123})
    @DisplayName("increaseProgress (음수 입력 예외):[success]")
    void increaseProgress_NegativeAmount(int input) {
        //when&then
        assertThatThrownBy(() -> Progress.from(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.COMMON_ERROR_HEADER.concat("음수 상태 값은 허용되지 않습니다."));
    }
}