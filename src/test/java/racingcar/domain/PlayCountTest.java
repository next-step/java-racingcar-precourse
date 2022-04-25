package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayCountTest {

    @Test
    public void 경주_시도_횟수를_받을_수_있다() {
        // given & when & then
        assertDoesNotThrow(()->{
            new PlayCount("1");
        });
    }

    @Test
    public void 경주_시도_횟수는_숫자여야_한다() {
        //given & when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PlayCount("aa");
        });
        //then
        assertThat(exception).hasMessage("시도 횟수는 숫자여야 한다.");
    }

}