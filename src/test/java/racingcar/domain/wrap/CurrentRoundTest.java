package racingcar.domain.wrap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.ErrorMessage.INVALID_ROUND_NUMBER_BOUNDARY_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022-04-24 오후 9:06
 */
@DisplayName("Domain:Wrap:CurrentRound")
class CurrentRoundTest {

    @Test
    @DisplayName("int의 원시타입으로 표현되는 현재 라운드 수 포장 객체 생성 Test")
    public void createCurrentRoundTest() {
        // Given
        int round = 5;

        // When
        CurrentRound currentRound = new CurrentRound(round);

        // Then
        assertThat(currentRound.getCurrentRound()).isEqualTo(round);
    }

    @Test
    @DisplayName("int의 원시타입으로 표현되는 현재 라운드 수 포장 객체 생성 실패 Test")
    public void createCurrentRoundFailTest() {
        // Given
        int round = 0;

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CurrentRound(round))
                .withMessageContaining(INVALID_ROUND_NUMBER_BOUNDARY_MESSAGE);
    }
}