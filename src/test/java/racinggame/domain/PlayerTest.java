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
}
