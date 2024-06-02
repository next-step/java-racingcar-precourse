import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class RacingCarGameTest {

    RacingCarGame Game = new RacingCarGame();

    @Test
    @DisplayName("자동차 이름 검증하기")
    public void getCarNames(){
        String shortName = "short";
        Assertions.assertThat(Game.validName(shortName)).isTrue();

        String longName = "tooLongName";
        Assertions.assertThatThrownBy(() -> Game.validName(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}