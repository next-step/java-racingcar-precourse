package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceNumberTest {

    @Test
    void 경주_횟수_입력_성공() {
        // Given
        String raceNumber = "2";
        // When & Then
        assertThat(new RaceNumber(raceNumber).getRaceNumber())
            .isEqualTo(Integer.parseInt(raceNumber));
    }

    @Test
    void 경주_횟수_입력_실패() {
        // Given
        String raceNumber = "실패";
        // When & Then
        assertThatThrownBy(() -> new RaceNumber(raceNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.WRONG_RACE_NUMBER.getMessage());
    }

    @Test
    void 경주_횟수가_양수가_아님() {
        // Given
        String raceNumber = "-1";
        // When & Then
        assertThatThrownBy(() -> new RaceNumber(raceNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.IS_ZERO.getMessage());
    }
}
