package racinggame.domain;

import org.junit.jupiter.api.Test;
import racinggame.exception.RaceGameException;

import static org.assertj.core.api.Assertions.*;

class RaceCarTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    public void 자동차_정상() throws Exception{
        RaceCar raceCar = new RaceCar("최웅석", 5);
        assertThat(raceCar.getName()).isEqualTo("최웅석");
        assertThat(raceCar.getMoveCount()).isEqualTo(5);
        assertThat(raceCar.getMoveRegex()).isEqualTo("-----");
    }

    @Test
    public void 자동차_예외_이름길이0() throws Exception{
        assertThatThrownBy(() -> {
            RaceCar raceCar = new RaceCar("", 5);
        }).hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    public void 자동차_예외_이름길이6() throws Exception{
        assertThatThrownBy(() -> {
            RaceCar raceCar = new RaceCar("123456", 5);
        }).hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    public void 자동차_예외_() throws Exception{
        assertThatThrownBy(() -> {
            RaceCar raceCar = new RaceCar("123456", 5);
        }).hasMessageContaining(ERROR_MESSAGE);
    }

}