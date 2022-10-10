package racingcar.model;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class racingcarPositionTest {
    @Test
    void 레이싱카_출발선_포지션_테스트(){
        racingcarPosition position = new racingcarPosition(0);
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 레이싱카_움직인후_포지션_테스트(){
        racingcarPosition position = new racingcarPosition(3);
        position.move();
        assertThat(position.getPosition()).isEqualTo(4);
        assertThat(position).hasToString("----");
    }
    @Test
    void 자동차_여러대_포지션_값_음수() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () ->
                new racingcarPosition(-1));
        assertEquals("[ERROR] position 값이 잘못 들어갔습니다.", e.getMessage());
    }


}
