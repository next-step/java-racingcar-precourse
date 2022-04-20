package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분하여 경주용 차를 생성한다.")
    void create_car(){
        String carNameList = "ck87,gater,atube";
        RacingCarGame racingCarGame = new RacingCarGame(carNameList);
        assertThat(racingCarGame).isNotNull();
    }
}
