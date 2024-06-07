package domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarCommandTest {

    @Test
    @DisplayName("유효 하지 않은 이름의 경우 예외 발생")
    void createRacingCarCommandTest() {
        // given
        List<String> nametest1 = List.of("a a");
        List<String> nametest2 = List.of("abcdef");

        // when, then
        //exception test
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RacingCarCommand.Create.from(nametest1));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RacingCarCommand.Create.from(nametest2));
    }

    @Test
    @DisplayName("유효 하지 않은 라운드의 경우 예외 발생")
    void createRacingRoundCommandTest() {
        // given
        String roundtest1 = "0";
        String roundtest2 = "-1";
        String roundtest3 = "a";

        // when, then
        //exception test
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RacingCarCommand.RacingRound.from(roundtest1));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RacingCarCommand.RacingRound.from(roundtest2));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RacingCarCommand.RacingRound.from(roundtest3));
    }

}
