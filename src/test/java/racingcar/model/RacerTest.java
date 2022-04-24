package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class RacerTest {

    @Test
    void 레이서_이름_5자_이상() {
        String name = "djfnddf";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Racer(name, 0);
        });
    }

}