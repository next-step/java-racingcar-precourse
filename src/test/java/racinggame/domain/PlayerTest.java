package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {


    @Test
    @DisplayName("경주 횟수와 자동차 이름 입력받기")
    void input()  {
        //given
        final Player player = new Player();
        //when
        player.inputRaceNumber(RaceNumber.of("2"));
        player.inputCarsName(InputCarsName.of("1번차,2번차,3번차"));
        //then
        assertThat(player.getInputCarsName().getName()).isEqualTo("1번차,2번차,3번차");
        assertThat(player.getRaceNumber().getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("경주 횟수 숫자가 아닌 문자 입력시 오류 발생")
    void inputNumber_fail() {
        //given
        final Player player = new Player();
        //when && then
        assertThatThrownBy(() -> player.inputRaceNumber(RaceNumber.of("숫자가아닌문자")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.IS_NOT_NUMBER.getMessage());

    }
}
